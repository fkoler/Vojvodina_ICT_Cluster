package com.iktpreobuka.myfirstproject.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

	@RequestMapping("/")
	public String hello() {
		return "My first application controller";
	}

	/*
	 * 2.1 endpoint koji vraća „Hello yourName!“
	 */
	@RequestMapping("/greetings")
	public String greetings() {
		String yourName = "Frank";

		return ("Hello " + yourName);
	}

	/*
	 * 2.2 endpoint koji vraća trenutni datum i vreme
	 */
	@RequestMapping("/date")
	public String getDate() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		return currentDateTime.format(formatter);
	}

	/*
	 * 2.3 endpoint koji drugi vraća listu koja sadrži imena članova Vaše porodice
	 */
	@RequestMapping("/family")
	public List<String> getFamilyMembers() {
		List<String> members = new ArrayList<>();

		members.add("Teodor");
		members.add("Dalia");
		members.add("Jasna");
		members.add("Ferenc");

		return members;
	}

	/*
	 * 2.4 endpoint koji vraća html stranicu sa imenima svih polaznika u grupi
	 */
	@RequestMapping("/myclass")
	public String getClassMembers() {
		List<String> members = new ArrayList<>();

		members.add("Polaznica 1");
		members.add("Polaznica 2");
		members.add("Polaznik 3");

		String membersString = String.join("</p><p style='margin-left: 40px'>", members);

		return "<h1>Polaznici Kursa</h1><p style='margin-left: 40px'>" + membersString + "</p>";
	}

	/*
	 * 3.1 endpoint koji vraća niz celobrojnih vrednosti
	 */
	@RequestMapping("/array")
	public int[] getArray() {
		int[] arr = { 9, 2, 3, 7, 8, 1, 5, 0, 6, 4 };

		return arr;
	}

	/*
	 * 3.2 endpoint koji vraća sortiran niz celobrojnih vrednosti
	 */
	@RequestMapping("/sortarray")
	public int[] getSortedArray() {
		int[] arr = { 9, 2, 3, 7, 8, 1, 5, 0, 6, 4 };
		Arrays.sort(arr);

		return arr;
	}

	/*
	 * 3.3 endpoint koji vraća minimalnu i maksimalnu vrednost iz niza
	 */
	@RequestMapping("/minmax")
	public String getMinMax() {
		int[] arr = { 9, 2, 3, 7, 8, 1, 5, 0, 6, 4 };
		Arrays.sort(arr);

		int min = arr[0];
		int max = arr[arr.length - 1];

		return "Min: " + min + "<br> Max: " + max;
	}

	/*
	 * 3.4 endpoint koji vraća sumu prvih n brojeva
	 */
	@RequestMapping("/sumaNiza")
	public String getArraySum() {
		int[] arr = { 9, 2, 3, 7, 8, 1, 5, 0, 6, 4 };

		int n = 5;

		int sum = 0;

		for (int i = 0; i < n && i < arr.length; i++) {
			sum += arr[i];
		}

		return "<h2>The sum of the first " + n + " numbers from the array is: " + sum + "</h2>";
	}

	/*
	 * 3.5 endpoint koji predstavlja englesko-srpski rečnik i koji za reč na srpskom
	 * vrati odgovarajući prevod na engleski jezik • putanja /recnik • DODATNO:
	 * ukoliko za traženu reč ne postoji prevod, tada ispisati „Rec tražena_rec ne
	 * postoji u recniku.“
	 */

	@RequestMapping("/recnik")
	public Map<String, String> translate() {
		Map<String, String> dictionary = Map.of("Pas", "Dog", "Pile", "Chicken", "Dabar", "Beaver");

		String word = "Zec";

		String translation = dictionary.get(word);

		if (translation != null) {
			return Map.of(word, translation);
		} else {
			return Map.of("Word", word + " not found in the dictionary.");
		}
	}
}
