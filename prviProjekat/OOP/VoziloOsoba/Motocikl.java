package VoziloOsoba;

public class Motocikl extends Vozilo {
	
	private boolean registrovan;
	
	public Motocikl(){}

	public Motocikl(
			String marka,
			String tip,
			boolean radi,
			String tipMotora,
			int snaga, int kubikaza,
			String registracija,
			int godiste, 
			Osoba vlasnik, 
			boolean registrovan
			) {
		super(marka, tip, radi, tipMotora, snaga, kubikaza, registracija, godiste, vlasnik);
		this.setRegistrovan(registrovan);
	}

	public boolean getRegistrovan() {
		return this.registrovan;
	}

	public void setRegistrovan(boolean registrovan) {
		this.registrovan = registrovan;
	}

	public void stampajPodatke() {
		System.out.println(this.getMarka() + " " + this.getTip() 
				   + " " + this.getGodiste() + " " + this.getRegistracija()
				   + " " + this.getRegistrovan() + " " + vlasnik.getIme() 
				   + " " + vlasnik.getPrezime());
	}
}
