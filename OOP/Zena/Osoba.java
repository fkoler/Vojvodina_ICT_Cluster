package Zena;

public class Osoba {

	protected String ime; 		
	protected String prezime;   
	protected int starost;
	
	public Osoba() {}
	
	public Osoba(String ime, String prezime, int starost){
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setStarost(starost); 
	}
	
	protected String getIme() {
		return this.ime;
	}
	
	protected void setIme(String ime) {
		this.ime = ime;
	}
	
	protected String getPrezime() {
		return this.prezime;
	}
	
	protected void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	protected int getStarost() {
		return this.starost;
	}
	
	protected void setStarost(int starost) {
		this.starost = starost;
	}
	
	void predstaviSe() {
		System.out.println(
				"Ime: " + this.getIme() + 
				" Prezime: " + this.getPrezime() + 
				" Starost: " + this.getStarost() + " godina");
	}
}
