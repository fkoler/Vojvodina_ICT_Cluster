package FakultetInterface;

public class Asistent extends Zaposleni implements IPlata{

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
	
	public void racunajPlatu() {
		this.setPlatu(40000 + (this.getGodinaDoktorskihStudija() * 3000));		
	}	
	
	public void stampajPlatu() {
		System.out.printf(
			"\nAsistent: %s %s, ima platu: %.2f \n", 
			this.getIme(), this.getPrezime(), this.getPlatu());
	}

	protected void predstaviSe() {
		System.out.println(
			"Ime: " + getIme() + 
			" Prezime: " + getPrezime() + 
			" Starost: " + getStarost() + 
			" Godina studija: " + this.getGodinaDoktorskihStudija() +
			" Mentor: " + this.getMentor());
	}	
}
