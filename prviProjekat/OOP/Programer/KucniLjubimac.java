package Programer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class KucniLjubimac {
	private String vlasnik;
	private String ime;
	private String vrsta;
	private double cena;

	public KucniLjubimac(String vlasnik, String ime, String vrsta, double cena) {
		this.vlasnik = vlasnik;
		this.ime = ime;
		this.vrsta = vrsta;
		this.cena = cena;
	}

	// Get metode za pristupanje privatnim atributima
	public String getVlasnik() {
		return vlasnik;
	}

	public String getIme() {
		return ime;
	}

	public String getVrsta() {
		return vrsta;
	}

	public double getCena() {
		return cena;
	}

	public static void main(String[] args) {
		ArrayList<KucniLjubimac> listaLjubimaca = ucitajPodatke("OOP\\Programer\\ljubimac.txt");

		// Ispisujemo ucitane ljubimce
		for (KucniLjubimac ljubimac : listaLjubimaca) {
			System.out.println("Vlasnik: " + ljubimac.getVlasnik() + ", Ime: " + ljubimac.getIme() + ", Vrsta: "
					+ ljubimac.getVrsta() + ", Cena: " + ljubimac.getCena());
		}
	}

	public static ArrayList<KucniLjubimac> ucitajPodatke(String imeDatoteke) {
		ArrayList<KucniLjubimac> listaLjubimaca = new ArrayList<>();

		try {
			File file = new File(imeDatoteke);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String linija = scanner.nextLine();
				String[] delovi = linija.split(" ");

				// Ako red ima tačno 4 dela, pretpostavljamo da su u ispravnom formatu
				if (delovi.length == 4) {
					String vlasnik = delovi[0];
					String ime = delovi[1];
					String vrsta = delovi[2];
					double cena = Double.parseDouble(delovi[3]);

					KucniLjubimac ljubimac = new KucniLjubimac(vlasnik, ime, vrsta, cena);
					listaLjubimaca.add(ljubimac);
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datoteka '" + imeDatoteke + "' nije pronađena.");
			e.printStackTrace();
		}

		return listaLjubimaca;
	}
}
