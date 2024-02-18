package VoziloOsoba;

public class Kamion extends Vozilo {
	private int brojOsovina;

	Kamion() {
	}

	Kamion(String marka, String tip, String registracija, int godiste, Osoba vlasnik, int brojOsovina) {
		super(marka, tip, registracija, godiste, vlasnik);
		this.brojOsovina = brojOsovina;
	}

	public int getBrojOsovina() {
		return brojOsovina;
	}

	public void setBrojOsovina(int brojOsovina) {
		this.brojOsovina = brojOsovina;
	}

	public void stampajPodatke() {
		System.out.println(this.getMarka() + " " + this.getTip() 
				   + " " + this.getGodiste() + " " + this.getRegistracija()
				   + " " + this.getBrojOsovina() + " " + vlasnik.getIme() 
				   + " " + vlasnik.getPrezime());
	}
}
