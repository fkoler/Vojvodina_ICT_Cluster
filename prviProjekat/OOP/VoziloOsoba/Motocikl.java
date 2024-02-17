package VoziloOsoba;

public class Motocikl extends Vozilo {
	
	private boolean registrovan;
	
	Motocikl(){}

	Motocikl(String marka, String tip, String registracija, int godiste, Osoba vlasnik, boolean registrovan) {
		super(marka, tip, registracija, godiste, vlasnik);
		this.registrovan = registrovan;
	}

	public boolean isRegistrovan() {
		return registrovan;
	}

	public void setRegistrovan(boolean registrovan) {
		this.registrovan = registrovan;
	}

	public void stampajPodatke() {
		System.out.println(this.getMarka() + " " + this.getTip() 
				   + " " + this.getGodiste() + " " + 					this.getRegistracija()
				   + " " + this.isRegistrovan() + " " + vlasnik.getIme() 
				   + " " + vlasnik.getPrezime());
	}
}
