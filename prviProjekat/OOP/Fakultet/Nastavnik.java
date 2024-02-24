package Fakultet;

/*Klasa Nastavnik ima dodatne atribute zvanje (tipa String) i brojSCIRadova (tipa int),
 * realizovati metodu predstaviSe i racunajPlatu
 * platu za nastavnike računati kao 60000+brojSCIRadova*3000
*/

public class Nastavnik extends Zaposleni {

	private String zvanje;
	private int brojSCIradova;
	
	public Nastavnik() {}
	
	public Nastavnik(
			String ime,
			String prezime, 
			int starost, 
			double koefRadnogMesta,
			int brojSciRadova, 
			String zvanje
			) {
		super(ime, prezime, starost, koefRadnogMesta);
		this.setBrojSCIradova(brojSciRadova);
		this.setZvanje(zvanje);
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public int getBrojSCIradova() {
		return brojSCIradova;
	}

	public void setBrojSCIradova(int brojSCIradova) {
		this.brojSCIradova = brojSCIradova;
	}	
	
	public double racunajPlatu() {
		plata = 60000 + (this.getBrojSCIradova() * 3000);
		return plata;
	}	

	@Override protected void predstaviSe() {
		System.out.println("Ime: " + getIme() + " Prezime: " + getPrezime() + 
				           " Starost: " + getStarost() + " Zvanje: " + getZvanje() + " Broj SCI radova:" + getBrojSCIradova());
	}
}
