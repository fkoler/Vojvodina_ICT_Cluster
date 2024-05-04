package Zena;

public class Zena extends Osoba {	

	String devojackoPrezime;
	
	public Zena() {}
	
	public Zena(
			String ime,
			String prezime,
			String devojackoPrezime,
			int starost
			){
		super(ime, prezime, starost);
		this.devojackoPrezime = devojackoPrezime;
	}
	
	public String pribaviDevojackoPrezime(){
		return this.devojackoPrezime;
	}
	
	public void postaviDevojackoPrezime(String devojackoPrezime){
		this.devojackoPrezime = devojackoPrezime;
	}
	
	void predstaviSe() {
		System.out.println(
			"Ime: " + getIme() +
			" Prezime: " + getPrezime() +
			" Devojacko prezime: " + pribaviDevojackoPrezime() +
			" Starost: " + this.getStarost() + " godina");
	}
}
