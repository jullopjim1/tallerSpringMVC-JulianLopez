package org.springframework.samples.petclinic.visit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitRestController {

	@Autowired
	private VisitService visitService;

	@RequestMapping(value = "/visits", method = RequestMethod.GET, params = { "filter" })
	public List<Visit> billsFiltro(@RequestParam("filter") String filter) {
		List<Visit> visitss = new ArrayList<Visit>();
		if (filter.equals("pagadas")) {
			visitss = visitService.getVisitByBillNotNull();
		}
		if (filter.equals("no_pagadas")) {
			visitss = visitService.getVisitByBillNull();
		}

		return visitss;
	}
}
