package VoziloOsoba;

public class Automobil extends Vozilo {
	private int brojVrata;

	Automobil() {
	}

	Automobil(String marka, String tip, String registracija, int godiste, Osoba vlasnik, int brojVrata) {
		super(marka, tip, registracija, godiste, vlasnik);
		this.brojVrata = brojVrata;
	}

	public int getBrojVrata() {
		return brojVrata;
	}

	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
	}

	public void stampajPodatke() {
		System.out.println(this.getMarka() + " " + this.getTip() 
				   + " " + this.getGodiste() + " " + this.getRegistracija()
				   + " " + this.getBrojVrata() + " " + vlasnik.getIme() + " "
				   + vlasnik.getPrezime());
	}
}
