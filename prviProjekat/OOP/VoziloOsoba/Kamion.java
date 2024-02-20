package VoziloOsoba;

public class Kamion extends Vozilo {
	
	private int brojOsovina;

	public Kamion() {}

	public Kamion(
			String marka,
			String tip,
			boolean radi,
			String tipMotora,
			int snaga,
			int kubikaza,
			String registracija, 
			int godiste,
			Osoba vlasnik, 
			int brojOsovina
			) {
		super(marka, tip, radi, tipMotora, snaga, kubikaza, registracija, godiste, vlasnik);
		this.setBrojOsovina(brojOsovina);
	}

	public int getBrojOsovina() {
		return this.brojOsovina;
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
