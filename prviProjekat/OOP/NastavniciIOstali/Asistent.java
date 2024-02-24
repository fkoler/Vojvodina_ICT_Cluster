package NastavniciIOstali;

public class Asistent extends Zaposleni {
	
	/*
	 * klasa Asistent ima dodatne atribute mentor (tipa
String) i godinaDoktorskihStudija (tipa int)
	 */
	
	private String mentor;
	private int godinaDoktorskihStudija;
	
	public Asistent() {}
	
	public Asistent(
			String ime,
			String prezime,
			int starost,
			double koefRadnogMesta,
			int godinaDoktorskihStudija,
			String mentor
			) {
		super(ime, prezime, starost, koefRadnogMesta);
		this.setGodinaDoktorskihStudija(godinaDoktorskihStudija);
		this.setMentor(mentor);
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public int getGodinaDoktorskihStudija() {
		return godinaDoktorskihStudija;
	}

	public void setGodinaDoktorskihStudija(int godinaDoktorskihStudija) {
		this.godinaDoktorskihStudija = godinaDoktorskihStudija;
	}
	
	public double racunajPlatu() {
		plata = 40000 + (this.getGodinaDoktorskihStudija() * 3000);
		return plata;
	}	

	@Override protected void predstaviSe() {
		System.out.println("Ime: " + getIme() + " Prezime: " + getPrezime() + 
				           " Starost: " + getStarost() + " Godina studija: " + this.getGodinaDoktorskihStudija() + " Mentor: " + this.getMentor());
	}
}
