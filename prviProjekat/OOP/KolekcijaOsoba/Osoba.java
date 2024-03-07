package KolekcijaOsoba;

public class Osoba {

	private String ime;
	private String prezime;
	private String jmbg;

	Osoba() {}

	public Osoba(String ime, String prezime, String jmbg) {
		this.postaviIme(ime);
		this.postaviPrezime(prezime);
		this.postaviJMBG(jmbg);
	}

	public String pribaviIme() {
		return this.ime;
	}

	public String pribaviPrezime() {
		return this.prezime;
	}

	public String pribaviJMBG() {
		return this.jmbg;
	}

	public void postaviIme(String ime) {
		this.ime = ime;
	}

	public void postaviPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void postaviJMBG(String jmbg) {
		this.jmbg = jmbg;
	}

	@Override
	public String toString() {
		return ("{Ime: " + this.pribaviIme() + " Prezime: " + this.pribaviPrezime() + " JMBG: " + this.pribaviJMBG()
				+ "}\n");
	}
}
