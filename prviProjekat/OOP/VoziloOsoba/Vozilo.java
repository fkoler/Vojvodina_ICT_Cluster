package VoziloOsoba;

public class Vozilo {
	
	protected String marka;
	protected String tip;
	protected String registracija;
	protected int godiste;
	protected Osoba vlasnik;
	
	Vozilo(){}

	Vozilo(String marka, String tip, String registracija, int godiste, Osoba vlasnik) {
		this.marka = marka;
		this.tip = tip;
		this.registracija = registracija;
		this.godiste = godiste;
		this.vlasnik = vlasnik;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getRegistracija() {
		return registracija;
	}

	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public Osoba getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Osoba vlasnik) {
		this.vlasnik = vlasnik;
	}

	protected void prenosVlasnistva(Osoba noviVlasnik) {
		this.vlasnik = noviVlasnik;
	}	

	protected void stampajPodatke() {
		System.out.println(getMarka() + " " + this.getTip() + " " 
									  + this.getGodiste() + " " + this.getRegistracija() + " " 
									  + this.vlasnik.getIme() + " " 
									  + this.vlasnik.getPrezime());
		}
	}
