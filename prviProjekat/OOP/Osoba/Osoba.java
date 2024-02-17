package Osoba;

public class Osoba {

	protected String ime;
	protected String prezime;
	protected int starost;
	protected double koeficijent;
	protected double plata;

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
	
	public double pribaviKoefRadnogMesta() {
		return this.koeficijent;
	}
	
	public double pribaviPlatu() {
		return this.plata;
	}
	
	public void predstaviSe() {
		System.out.println("Ime: " + this.getIme()
		+ " Prezime: " + this.getPrezime()
		+ " Starost: " + this.getStarost()
		+ " godina");
		}
}
