package PoslovanjeBanaka;

public class Klijent {

	private String ime;
	private String prezime;
	private String jmbg;
	private Racun brojRacuna;
	
	public Klijent() {}
	
	public Klijent(String ime, String prezime, String jmbg) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setJmbg(jmbg);
		this.brojRacuna = new Racun(1000, true, "EUR");
		this.setBrojRacuna(brojRacuna);		
	}

	public Racun getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(Racun brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
}
