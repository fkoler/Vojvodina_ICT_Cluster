package com.iktobuka.rest_examples1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.rest_examples1.entities.BankClientEntity;

@RestController
@RequestMapping("/bankclients")
public class BankClientRestController {

	@RequestMapping(method = RequestMethod.GET)
	public List<BankClientEntity> getAll() {
		List<BankClientEntity> clients = new ArrayList<>();

		clients.add(new BankClientEntity(1, "Frenk", "Speck", "frenk@frenk.io"));
		clients.add(new BankClientEntity(2, "Jasna", "Colore", "jasna@jasna.io"));

		return clients;
	}
}
