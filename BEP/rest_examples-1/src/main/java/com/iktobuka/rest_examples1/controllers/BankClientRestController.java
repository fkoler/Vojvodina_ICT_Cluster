package com.iktobuka.rest_examples1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktobuka.rest_examples1.entities.BankClientEntity;

@RestController
@RequestMapping("/bankclients")
public class BankClientRestController {

	private List<BankClientEntity> getDB() {
		List<BankClientEntity> clients = new ArrayList<>();

		clients.add(new BankClientEntity(1, "Frenk", "Speck", "frenk@frenk.io"));
		clients.add(new BankClientEntity(2, "Jasna", "Colore", "jasna@jasna.io"));

		return clients;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<BankClientEntity> getAll() {

		return getDB();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{clientId}")
	public BankClientEntity getById(@PathVariable String clientId) {

//		if (clientId.equals("1")) {
//			return new BankClientEntity(1, "Frenk", "Speck", "frenk@frenk.io");
//		} else {
//			return new BankClientEntity();
//		}

		List<BankClientEntity> clients = getDB();
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).getId().equals(Integer.parseInt(clientId))) {
				return clients.get(i);
			}
		}

		return new BankClientEntity();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addNewBankClient(@RequestBody BankClientEntity newClient) {
		System.out.println(newClient.getName().concat(" ").concat(newClient.getSurname()));

		return "New Client added";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{clientId}")
	public BankClientEntity modifyBankClient(@RequestBody BankClientEntity client, @PathVariable String clientId) {
		BankClientEntity bc = new BankClientEntity(1, "Frenk", "Speck", "frenk@frenk.io");

		if (clientId.equals("1")) {
			bc.setName(client.getName());
			bc.setSurname(client.getSurname());
			return bc;
		} else {
			return new BankClientEntity();
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{clientId}")
	public BankClientEntity deleteBankClient(@PathVariable String clientId) {

		for (BankClientEntity bc : getDB()) {
			if (bc.getId().equals(Integer.parseInt(clientId))) {
				System.out.println("Client '" + bc.getName() + "' is successfully deleted");
				getDB().remove(bc);
				return bc;
			}
		}

		return new BankClientEntity();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/client")
	public BankClientEntity getByNameSurname(@RequestParam("name") String name,
			@RequestParam("surname") String surname) {
		if (name.equals("Frenk") && surname.equals("Speck")) {
			return new BankClientEntity(1, "Frenk", "Speck", "frenk@frenk.io");
		} else {
			return new BankClientEntity();
		}
	}
}
