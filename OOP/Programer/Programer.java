package Programer;

public class Programer {

	protected String ime, prezime, senior;
	protected int godine;
	protected double plata;

	public Programer() {}
	
	public Programer(
			String ime,
			String prezime,
			int godine, 
			String senior, 
			double plata
		) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setGodine(godine);
		this.setSenior(senior);
		this.setPlata(plata);
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

	public String getSenior() {
		return senior;
	}

	public void setSenior(String senior) {
		this.senior = senior;
	}

	public int getGodine() {
		return godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}
}
