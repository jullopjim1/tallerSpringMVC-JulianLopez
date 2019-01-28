package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;

	public List<PetType> findPetTypes() {
		return petRepository.findPetTypes();
	}

	public Pet findById(Integer id) {
		return petRepository.findById(id);
	}

	public void save(Pet pet) {
		petRepository.save(pet);
	}
	
	

}
