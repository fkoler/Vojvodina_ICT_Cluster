package Osoba;

public class Klijent extends Osoba {

	private int jmbg;
	private String adresa;
	private double stanjeRacuna;

	Klijent() {
	}

	Klijent(String ime, String prezime, int starost, int jmbg, String adresa, double stanjeRacuna) {
		super(ime, prezime, starost);
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.stanjeRacuna = stanjeRacuna;
	}

	public int getJmbg() {
		return jmbg;
	}

	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public double getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(double stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}
	
	public void moneyTransfer (double k1, double k2) {
		
	}

	public void ispisiKlijenta() {
		System.out.println("Ime: " + this.getIme() + ", Prezime: " + this.getPrezime() + ", Starost: " + this.getStarost()
				+ ", JMBG:" + this.getJmbg() + ", adresa: " + this.getAdresa() + ", StanjeRacuna: "
				+ this.getStanjeRacuna());
	}
}
