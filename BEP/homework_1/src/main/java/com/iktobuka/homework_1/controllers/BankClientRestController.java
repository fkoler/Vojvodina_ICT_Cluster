package com.iktobuka.homework_1.controllers;

import java.time.LocalDate;
import java.time.Period;
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

		clients.add(
				new BankClientEntity(1, "Barack", "Obama", "barack@obama.io", LocalDate.of(1961, 8, 4), "Washington"));
		clients.add(
				new BankClientEntity(2, "Angela", "Merkel", "angela@merkel.io", LocalDate.of(1954, 7, 17), "Berlin"));
		clients.add(new BankClientEntity(3, "Elon", "Musk", "elon@musk.io", LocalDate.of(1971, 6, 28), "Los_Angeles"));
		clients.add(
				new BankClientEntity(4, "Oprah", "Winfrey", "oprah@winfrey.io", LocalDate.of(1954, 1, 29), "Chicago"));
		clients.add(new BankClientEntity(5, "Jeff", "Bezos", "jeff@bezos.io", LocalDate.of(1964, 1, 12), "Seattle"));
		clients.add(new BankClientEntity(6, "Bill", "Gates", "bill@gates.io", LocalDate.of(1955, 10, 28), "Seattle"));
		clients.add(
				new BankClientEntity(7, "Warren", "Buffett", "warren@buffett.io", LocalDate.of(1930, 8, 30), "Omaha"));
		clients.add(new BankClientEntity(8, "Larry", "Page", "larry@page.io", LocalDate.of(1973, 3, 26), "Palo_Alto"));
		clients.add(new BankClientEntity(9, "Mark", "Cuban", "mark@cuban.io", LocalDate.of(1958, 7, 31), "Dallas"));
		clients.add(new BankClientEntity(10, "Richard", "Branson", "richard@branson.io", LocalDate.of(1950, 7, 18),
				"London"));

		return clients;
	}

	private List<BankClientEntity> clients = getDB();

//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

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

//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	private int calculateAge(LocalDate dateOfBirth) {
		LocalDate now = LocalDate.now();
		return Period.between(dateOfBirth, now).getYears();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/clients/bonitet")
	public List<BankClientEntity> setCreditRatings() {

		for (BankClientEntity client : clients) {
			LocalDate dob = client.getDateOfBirth();
			char creditRating = 'N';

			if (calculateAge(dob) < 65) {
				creditRating = 'P';
			}

			client.setCreditRating(creditRating);
		}

		return clients;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clients/delete")
	public String deleteClient() {
		List<BankClientEntity> validClients = new ArrayList<>();

		for (BankClientEntity client : clients) {
			if (!client.getName().isEmpty() && !client.getSurname().isEmpty() && !client.getEmail().isEmpty()) {
				validClients.add(client);
			}
		}

		clients = validClients;
		return "Clients without required information have been successfully removed.";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clients/countLess/{years}")
	public List<BankClientEntity> youngerThan(@PathVariable int years) {
		List<BankClientEntity> result = new ArrayList<>();

		for (BankClientEntity client : clients) {
			if (calculateAge(client.getDateOfBirth()) < years) {
				result.add(client);
			}
		}

		return result;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clients/averageYears")
	public double averageClientAge() {
		int totalAge = 0;

		for (BankClientEntity client : clients) {
			totalAge += calculateAge(client.getDateOfBirth());
		}

		return (double) totalAge / clients.size();
	}

//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@RequestMapping(method = RequestMethod.PUT, value = "/clients/changelocation/{clientId}")
	public String changeLocation(@PathVariable int clientId, @RequestParam("city") String city) {

		for (BankClientEntity client : clients) {
			if (client.getId() == clientId) {
				String currentCity = client.getCity();
				client.setCity(city);

				return "Residence of the client " + client.getName() + " " + client.getSurname() + " from "
						+ currentCity + " successfully changed to " + city;
			}
		}

		return "Client with ID " + clientId + " not found.";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clients/from/{city}")
	public List<BankClientEntity> getClientsFromCity(@PathVariable String city) {
		List<BankClientEntity> clientsFromCity = new ArrayList<>();

		for (BankClientEntity client : clients) {
			if (client.getCity() != null && client.getCity().equalsIgnoreCase(city)) {
				clientsFromCity.add(client);
			}
		}

		return clientsFromCity;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clients/findByCityAndAge")
	public List<BankClientEntity> getClientsByCityAndAge(@RequestParam("city") String city,
			@RequestParam("age") int age) {
		List<BankClientEntity> matchingClients = new ArrayList<>();

		for (BankClientEntity client : clients) {
			if (client.getCity() != null && client.getCity().equalsIgnoreCase(city)
					&& calculateAge(client.getDateOfBirth()) < age) {
				matchingClients.add(client);
			}
		}

		return matchingClients;
	}
}
