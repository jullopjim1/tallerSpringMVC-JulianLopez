package org.springframework.samples.petclinic.visit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

	@Autowired
	private VisitRepository visitRepository;

	public Visit findOne(Integer id) {
		return visitRepository.findOne(id);
	}

	public void save(Visit visit) throws DataAccessException {
		visitRepository.save(visit);
	}

	public List<Visit> findByPetId(Integer petId) {
		return visitRepository.findByPetId(petId);
	}

	public List<Visit> getVisitByBillNotNull() {
		return visitRepository.getVisitByBillNotNull();
	}

	public List<Visit> getVisitByBillNull() {
		return visitRepository.getVisitByBillNull();
	}

}
