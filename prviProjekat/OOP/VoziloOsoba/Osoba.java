package VoziloOsoba;

public class Osoba {
	
	protected String ime;
	protected String prezime;
	protected int starost;
	
	

	Osoba() {}

	Osoba(String ime, String prezime, int starost) {
		this.ime = ime;
		this.prezime = prezime;
		this.starost = starost;
	}
	
	public String getIme() {
		return this.ime;
	}
	
	public String getPrezime() {
		return this.prezime;
	}
	
	public int getStarost() {
		return this.starost;
	}
	
	public void predstaviSe() {
		System.out.println("Ime: " + this.getIme()
		+ " Prezime: " + this.getPrezime()
		+ " Starost: " + this.getStarost()
		+ " godina");
		}
}
