package MaliFudbal;

public class KlasaUtakmica {

	public enum RezultatUtakmice {
		NEODIGRANA,
		PRVI_POBEDIO, 
		DRUGI_POBEDIO,
		NERESENO
	}

	private String prviTim;
	private String drugiTim;
	private RezultatUtakmice rezultat;
	
	// Konstruktor
	public KlasaUtakmica() {}

	public KlasaUtakmica(String prviTim, String drugiTim, RezultatUtakmice rezultat) {
		this.setPrviTim(prviTim);
		this.setDrugiTim(drugiTim);
		this.setRezultat(rezultat);
	}	

	// Get metode
	public String getPrviTim() {
		return prviTim;
	}

	public String getDrugiTim() {
		return drugiTim;
	}
	
	public RezultatUtakmice getRezultat() {
		return rezultat;
	}
	
	// Set metode
	public void setPrviTim(String prviTim) {
		this.prviTim = prviTim;
	}

	public void setDrugiTim(String drugiTim) {
		this.drugiTim = drugiTim;
	}	

	public void setRezultat(RezultatUtakmice rezultat) {
		this.rezultat = rezultat;
	}

	// Metoda za prikaz informacija o utakmicama
	@Override
	public String toString() {
		return String.format(
				"Utakmica: " + prviTim + " vs " +
				drugiTim + ", Rezultat: " + rezultat)
		;
	}
}
