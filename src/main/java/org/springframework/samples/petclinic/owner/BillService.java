package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	public List<Bill> getBillByVisitNotNull() {
		return billRepository.getBillByVisitNotNull();
	}

	public List<Bill> getBillByVisitNull() {
		return billRepository.getBillByVisitNull();
	}
	
	
}
