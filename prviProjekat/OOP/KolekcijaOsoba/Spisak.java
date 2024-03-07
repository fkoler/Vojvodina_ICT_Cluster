package KolekcijaOsoba;

import java.io.*;
import java.util.*;

public class Spisak {

	private ArrayList<Osoba> listaPolaznika;

	public void ucitajListu(String imeFajla) {

		Scanner s = null;
		ArrayList<Osoba> listaPolaznika = new ArrayList<Osoba>();

		try {
			s = new Scanner(new File(imeFajla));
			do {
				String ime = s.next();
				String prezime = s.next();
				String jmbg = s.next();
				Osoba noviPolaznik = new Osoba(ime, prezime, jmbg);
				listaPolaznika.add(noviPolaznik);
			} while (s.hasNext());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (s != null) {
				s.close();
			}
		}
		this.listaPolaznika = listaPolaznika;
	}

	public void sortirajListu() {
		Collections.sort(this.listaPolaznika, new MojKomparator());
	}
	
	public void obrniListu() {
		Collections.reverse(this.listaPolaznika);
	}

	public void stampajListu() {
		System.out.println(Arrays.toString(this.listaPolaznika.toArray()));
	}

	public void upisiListu(String imeFajla) {
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new FileOutputStream(imeFajla));
			for (Osoba polaznik : this.listaPolaznika)
				pw.println(polaznik.pribaviIme() + " " + polaznik.pribaviPrezime() + " " + polaznik.pribaviJMBG());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
