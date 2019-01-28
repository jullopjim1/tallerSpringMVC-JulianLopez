package org.springframework.samples.petclinic.visit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class VisitService {

	@Autowired
	private VisitRepository visitRepository;

	public void save(Visit visit) throws DataAccessException {
		visitRepository.save(visit);
	}

	public List<Visit> findByPetId(Integer petId) {
		return visitRepository.findByPetId(petId);
	}
	
	

}
