package com.iktobuka.homework_1.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.homework_1.entities.BankClientEntity;

@RestController
@RequestMapping("/bankclients")
public class BankClientRestController {

	private List<BankClientEntity> getDB() {
		List<BankClientEntity> clients = new ArrayList<>();

		clients.add(new BankClientEntity(1, "Albert", "Einstein", "albert@einstein.io"));
		clients.add(new BankClientEntity(2, "Marie", "Curie", "marie@curie.io"));
		clients.add(new BankClientEntity(3, "Isaac", "Newton", "isaac@newton.io"));
		clients.add(new BankClientEntity(4, "Charles", "Darwin", "charles@darwin.io"));
		clients.add(new BankClientEntity(5, "Galileo", "Galilei", "galileo@galilei.io"));
		clients.add(new BankClientEntity(6, "Nikola", "Tesla", "nikola@tesla.io"));
		clients.add(new BankClientEntity(7, "Stephen", "Hawking", "stephen@hawking.io"));
		clients.add(new BankClientEntity(8, "Ada", "Lovelace", "ada@lovelace.io"));
		clients.add(new BankClientEntity(9, "Leonardo", "da Vinci", "leonardo@davinci.io"));
		clients.add(new BankClientEntity(10, "Carl", "Sagan", "carl@sagan.io"));

		return clients;
	}

//	===============================

	@RequestMapping(method = RequestMethod.GET, value = "/emails")
	public List<String> getEmails() {
		List<String> emails = new ArrayList<>();
		List<BankClientEntity> clients = getDB();

		for (BankClientEntity bc : clients) {
			emails.add(bc.getEmail());
		}

		return emails;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clients/{firstLetter}")
	public List<String> getClientsByFirstLetter(@PathVariable char firstLetter) {
		List<String> matchingNames = new ArrayList<>();
		List<BankClientEntity> clients = getDB();

		for (BankClientEntity bc : clients) {
			if (bc.getName().toLowerCase().charAt(0) == Character.toLowerCase(firstLetter)) {
				matchingNames.add(bc.getName());
			}
		}

		return matchingNames;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clients/firstLetters")
	public List<String> getClientsByFirstLetters(@RequestParam("firstLetterName") char firstLetterName,
			@RequestParam("firstLetterSurname") char firstLetterSurname) {
		List<String> matchingNames = new ArrayList<>();
		List<BankClientEntity> clients = getDB();

		char upperCaseName = Character.toUpperCase(firstLetterName);
		char upperCaseSurname = Character.toUpperCase(firstLetterSurname);

		for (BankClientEntity bc : clients) {
			if (bc.getName().toUpperCase().charAt(0) == upperCaseName
					&& bc.getSurname().toUpperCase().charAt(0) == upperCaseSurname) {
				matchingNames.add(bc.getName() + " " + bc.getSurname());
			} else {
				matchingNames = new ArrayList<>();
			}
		}

		return matchingNames;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clients/sort/{order}")
	public List<String> sortClients(@PathVariable String order) {
		List<String> sortedNames = new ArrayList<>();
		List<BankClientEntity> clients = getDB();

		for (BankClientEntity bc : clients) {
			sortedNames.add(bc.getName());
		}

		if (order.toLowerCase().equals("asc")) {
			Collections.sort(sortedNames);
		} else if (order.toLowerCase().equals("desc")) {
			Collections.sort(sortedNames, Collections.reverseOrder());
		} else {
			sortedNames = new ArrayList<>();
		}

		return sortedNames;
	}

//	===============================
}
