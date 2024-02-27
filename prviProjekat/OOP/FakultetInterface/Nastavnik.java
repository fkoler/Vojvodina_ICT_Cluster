package FakultetInterface;

public class Nastavnik extends Zaposleni implements IPlata{

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
	
	public void racunajPlatu() {		
		this.setPlatu(60000 + (this.getBrojSCIradova() * 3000));
	}
	
	public void stampajPlatu() {
		System.out.printf(
			"\nNastavnik: %s %s, ima platu: %.2f \n", this.getIme(), 
			this.getPrezime(), this.getPlatu());
	}

	protected void predstaviSe() {
		System.out.println(
				"Ime: " + getIme() + 
				" Prezime: " + getPrezime() + 
				" Starost: " + getStarost() + 
				" Zvanje: " + getZvanje() + 
				" Broj SCI radova:" + getBrojSCIradova());
	}
}
