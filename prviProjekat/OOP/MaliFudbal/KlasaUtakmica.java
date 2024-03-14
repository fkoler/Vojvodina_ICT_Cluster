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
	
	public KlasaUtakmica() {}

	public KlasaUtakmica(String prviTim, String drugiTim, RezultatUtakmice rezultat) {
		this.setPrviTim(prviTim);
		this.setDrugiTim(drugiTim);
		this.setRezultat(rezultat);
	}

	public void setPrviTim(String prviTim) {
		this.prviTim = prviTim;
	}

	public void setDrugiTim(String drugiTim) {
		this.drugiTim = drugiTim;
	}
	
	public RezultatUtakmice getRezultat() {
		return rezultat;
	}

	public String getPrviTim() {
		return prviTim;
	}

	public String getDrugiTim() {
		return drugiTim;
	}

	public void setRezultat(RezultatUtakmice rezultat) {
		this.rezultat = rezultat;
	}

	@Override
	public String toString() {
		return "Utakmica: " + prviTim + " vs " + drugiTim + ", Rezultat: " + rezultat;
	}
}
