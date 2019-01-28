package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import com.fasterxml.jackson.annotation.JsonBackReference;

@RestController
@RequestMapping("/bills")
public class BillController {

	@Autowired
	private BillService billService;

	@Autowired
	private VisitService visitService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Bill> list() {
		List<Bill> bills = billService.findAll();
		return bills;
	}

	@RequestMapping(value = "/{billId}", method = RequestMethod.GET)
	public Bill findOne(@PathVariable("billId") int billId) {
		Bill bill = billService.findOne(billId);
		return bill;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Bill> put(@RequestBody Bill bill) {
		Bill billDB = billService.findOne(bill.getId());
		if (billDB != null) {
			bill.setMoney(billDB.getMoney());
			return ResponseEntity.status(HttpStatus.OK).body(billService.save(bill));
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		}

	}

	@RequestMapping(value = "/{billId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("billId") int billId) {
		billService.delete(billId);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Bill> post(@RequestBody Bill bill) {
		Bill billDB = billService.findOne(bill.getId());
		if (billDB != null) {
			bill.setMoney(billDB.getMoney());
			return ResponseEntity.status(HttpStatus.OK).body(billService.save(bill));
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.GET, params = { "filter" })
	public List<Bill> billsFiltro(@RequestParam("filter") String filter) {
		List<Bill> bills = new ArrayList<Bill>();
		if (filter.equals("pagadas")) {
			bills = billService.getBillByVisitNotNull();
		}
		if (filter.equals("no_pagadas")) {
			bills = billService.getBillByVisitNull();
		}

		return bills;
	}

	@RequestMapping(value = "/{billId}/visit/{visitId}", method = RequestMethod.GET)
	public Visit getbillVisit(@PathVariable("billId") int billId, @PathVariable("visitId") int visitId) {
		Bill bill = billService.findOne(billId);
		Visit visit = bill.getVisit();
		return visit;
	}

	@RequestMapping(value = "/{billId}/visit/{visitId}", method = RequestMethod.POST)
	public ResponseEntity<Bill> postbillVisit(@PathVariable("billId") int billId,
			@PathVariable("visitId") int visitId) {
		Bill bill = billService.findOne(billId);
		Visit visit = visitService.findOne(visitId);

		if (visit != null) {
			bill.setVisit(visit);
			return ResponseEntity.status(HttpStatus.OK).body(billService.save(bill));
		} else {
			bill.setVisit(visit);
			return ResponseEntity.status(HttpStatus.OK).body(billService.save(bill));
		}

	}
}
