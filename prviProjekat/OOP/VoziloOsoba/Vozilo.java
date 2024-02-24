package VoziloOsoba;

public class Vozilo{
	
	protected Motor pogonskiAgregat;
	protected String marka;
	protected String tip;
	protected String registracija;
	protected int godiste;
	protected Osoba vlasnik;
	
	public Vozilo(){}

	public Vozilo(
			String marka,
			String tip,
			boolean radi,
			String tipMotora,
			int snaga,
			int kubikaza,
			String registracija,
			int godiste,
			Osoba vlasnik
			) {
		this.setPogonskiAgregat(new Motor(radi, tipMotora, snaga, kubikaza));
		this.setMarka(marka);
		this.setTip(tip);
		this.setRegistracija(registracija);
		this.setGodiste(godiste);
		this.setVlasnik(vlasnik);
	}
	
	public Motor getPogonskiAgregat() {
		return pogonskiAgregat;
	}
	
	public void setPogonskiAgregat(Motor pogonskiAgregat) {
		this.pogonskiAgregat = pogonskiAgregat;
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

	public void prenosVlasnistva(Osoba noviVlasnik) {
		this.vlasnik = noviVlasnik;
	}	

	public void stampajPodatke() {
		System.out.println(
				getMarka() + " " + this.getTip() + " " 
				+ this.getGodiste() + " " + this.getRegistracija()
				+ " " + this.vlasnik.getIme() + " " 
				+ this.vlasnik.getPrezime());
		}
	}
