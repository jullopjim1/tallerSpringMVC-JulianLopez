package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;

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
