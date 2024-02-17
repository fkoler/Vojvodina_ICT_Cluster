package Vozila;

public class Vozila {
	private String marka, tip, registracija;
	private int godiste, maksBrzina, snaga, cena;

	Vozila() {}

	Vozila(
			String marka,
			String tip,
			String registracija,
			int godiste,
			int maksBrzina,
			int snaga
			) {
		this.setMarku(marka);
		this.setTip(tip);
		this.setRegistraciju(registracija);
		this.setGodiste(godiste);
		this.setMaksBrzinu(maksBrzina);
		this.setSnagu(snaga);
	}

	private void setMarku(String marka) {
		this.marka = marka;
	}
	
	private String getMarku() {
		return this.marka;
	}

	private void setTip(String tip) {
		this.tip = tip;

	}
	
	private String getTip() {
		return this.tip;

	}
	
	private void setRegistraciju(String registracija) {
		this.registracija = registracija;
	}
	
	private String getRegistraciju() {
		return this.registracija;
	}

	private void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	private int getGodiste() {
		return this.godiste;
	}

	private void setMaksBrzinu(int maksBrzina) {
		this.maksBrzina = maksBrzina;
	}

	private int getMaksBrzinu() {
		return this.maksBrzina;
	}

	private void setSnagu(int snaga) {
		this.snaga = snaga;
	}

	private int getSnagu() {
		return this.snaga;
	}

	public double racunajVrednost() {
		this.cena = this.getMaksBrzinu() * this.getSnagu() / (2021 - this.getGodiste());
		return cena;
	}

	void stampajVrednost() {
		System.out.printf("Automobil marke: %s, tipa: %s, registarskih oznaka: %s, godiste: %d, maksimalne brzine: %dkm/h, snage: %dkW,  cena je: %.2f \u20ac \n", this.getMarku(), this.getTip(), this.getRegistraciju(), this.getGodiste(), this.getMaksBrzinu(), this.getSnagu() , this.racunajVrednost());
	}

	void uporediVrednost(Vozila vozilo) {
		if (this.cena < vozilo.cena) {
			System.out.printf("Vozilo <%s> je jeftinije od vozila <%s>\n", this.getMarku(), vozilo.getMarku());
		} else if (this.cena > vozilo.cena) {
			System.out.printf("Vozilo <%s> je skuplje od vozila <%s>\n",this.getMarku(), vozilo.getMarku());
		} else {
			System.out.println("Cene ovih vozila su iste");
		}
	}
}
