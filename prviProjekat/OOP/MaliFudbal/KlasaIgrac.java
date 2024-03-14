package MaliFudbal;

public class KlasaIgrac {
	
	private String ime;
	private String prezime;
	private String jmbg;
	private String imeTima;
	
	public KlasaIgrac() {}

	// Konstruktor
	public KlasaIgrac(String ime, String prezime, String jmbg, String imeTima) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setJmbg(jmbg);
		this.setImeTima(imeTima);
	}	

	// Get metode
	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public String getImeTima() {
		return imeTima;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public void setImeTima(String imeTima) {
		this.imeTima = imeTima;
	}

	// Metoda za prikaz informacija o igraču
	@Override
	public String toString() {
	    return String.format("Igrač: %s %s, JMBG: %s, Tim: %s", ime, prezime, jmbg, imeTima);
	}
}
