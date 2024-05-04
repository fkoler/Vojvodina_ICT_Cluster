package PoslovanjeBanaka;

import java.util.ArrayList;

public class Banka implements RadSaTransakcijama {
	
	private String imeBanke;
	private ListaKlijenata klijenti;
	private ArrayList<Transakcija> transakcije;
	
	public Banka() {
		this.setImeBanke(imeBanke);
		this.klijenti = new ListaKlijenata();
		this.transakcije = new ArrayList<Transakcija>();
	}

	public String getImeBanke() {
		return imeBanke;
	}

	public void setImeBanke(String imeBanke) {
		this.imeBanke = imeBanke;
	}

	public ListaKlijenata getKlijenti() {
		return klijenti;
	}

	public ArrayList<Transakcija> getTransakcije() {
		return transakcije;
	}

	public void setKlijenti(ListaKlijenata klijenti) {
		this.klijenti = klijenti;
	}

	public void setTransakcije(ArrayList<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}
	
	public boolean izvrsiInternuTransakciju(Klijent posiljalac, Klijent primalac, float iznos) {
		
		float stanjePosiljalac = posiljalac.getBrojRacuna().getStanje();
		float stanjePrimalac = primalac.getBrojRacuna().getStanje();
		
		if (stanjePosiljalac >= iznos) {
			posiljalac.getBrojRacuna().setStanje(stanjePosiljalac - iznos);
			primalac.getBrojRacuna().setStanje(stanjePrimalac + iznos);
			return true;
		}
		else {
			System.out.println("Nema dovoljno na racunu.");
			return false;
		}
	}
}