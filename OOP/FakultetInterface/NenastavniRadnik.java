package FakultetInterface;

public class NenastavniRadnik extends Zaposleni {
	
	private String radnoMesto;
	private int godineStaza;
	
	public NenastavniRadnik() {}
	
	public NenastavniRadnik(
			String ime,
			String prezime,
			int starost,
			double plata,
			String radnoMesto,
			int godineStaza
			) {
		super(ime, prezime, starost, plata);		
		this.setRadnoMesto(radnoMesto);
		this.setGodineStaza(godineStaza);
	}

	public String getRadnoMesto() {
		return radnoMesto;
	}

	public void setRadnoMesto(String radnoMesto) {
		this.radnoMesto = radnoMesto;
	}

	public int getGodineStaza() {
		return godineStaza;
	}

	public void setGodineStaza(int godineStaza) {
		this.godineStaza = godineStaza;
	}	
	
	public double racunajPlatu() {		
		return plata = (30000 + (this.getGodineStaza() * 500));
	}
	
	public void stampajPlatu() {
		System.out.printf(
			"\nNenastavni radnik: %s %s, ima platu: %.2f \n", this.getIme(), 
			this.getPrezime(), racunajPlatu());
	}

	public void predstaviSe() {
		System.out.println(
				"Ime: " + getIme() + 
				", Prezime: " + getPrezime() + 
				", Starost: " + getStarost() + 
				", Radno mesto: " + this.getRadnoMesto() + 
				", Godine staža: " +this.getGodineStaza());
	}
}
