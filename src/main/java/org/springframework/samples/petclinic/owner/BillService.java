package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

	public void delete(Integer id) {
		billRepository.delete(id);
	}

	public Bill findOne(Integer id) {
		return billRepository.findOne(id);
	}

	@Autowired
	private BillRepository billRepository;

	public List<Bill> getBillByVisitNotNull() {
		return billRepository.getBillByVisitNotNull();
	}

	public List<Bill> getBillByVisitNull() {
		return billRepository.getBillByVisitNull();
	}

	public List<Bill> findAll() {
		return billRepository.findAll();
	}

	public Bill save(Bill entity) {
		return billRepository.save(entity);
	}

}
