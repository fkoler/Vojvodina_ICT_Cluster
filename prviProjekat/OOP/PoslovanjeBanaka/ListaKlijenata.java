package PoslovanjeBanaka;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ListaKlijenata implements RadSaKlijentima, RadSaFajlovima {

	private ArrayList<Klijent> klijenti;

	public ListaKlijenata() {
		this.klijenti = new ArrayList<Klijent>();
	}

	public void dodajKlijenta(Klijent k) {
		klijenti.add(k);
	}

	public int pronadjiKlijenta(String jmbg) {
		for (Klijent k : this.klijenti) {
			if (k.getJmbg().equalsIgnoreCase(jmbg)) {
				return klijenti.indexOf(k);
			}
		}
		return -1;
	}

	public void obrisiKlijenta(Klijent k) {
		int rezultatPretrage = this.pronadjiKlijenta(k.getJmbg());
		if (rezultatPretrage != -1) {
			this.klijenti.remove(rezultatPretrage);
			System.out.println("Klijent " + k.getIme() + " " + k.getPrezime() + " obrisan!");
		} else {
			System.out.println("Klijent " + k.getIme() + " " + k.getPrezime() + " nije pronadjen!");
		}
	}

	public void ucitajIzFajla(String imeFajla) {
		Scanner s = null;
		ArrayList<Klijent> klijenti = new ArrayList<Klijent>();

		try {
			s = new Scanner(new File(imeFajla));
			do {
				String ime = s.next();
				String prezime = s.next();
				String jmbg = s.next();
				Klijent noviKlijent = new Klijent(ime, prezime, jmbg);
				klijenti.add(noviKlijent);
			} while (s.hasNext());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (s != null) {
				s.close();
			}
		}
		this.klijenti = klijenti;
	}

	public void upisiUFajl(String imeFajla) {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(imeFajla)))) {
			for (Klijent k : this.klijenti) {
				pw.println(k.getIme() + " " + k.getPrezime() + " " + k.getJmbg());
				System.out.println("Podaci o klijentu " + k.getIme() + " " + k.getPrezime() + " uspesno upisani u fajl "
						+ imeFajla + "!");
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
