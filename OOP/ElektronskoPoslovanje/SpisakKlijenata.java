package ElektronskoPoslovanje;

public class SpisakKlijenata {

	private String[] nazivKlijenta;
	private int trenutniBrojKlijenata;
	private int maxBrojKlijenata;

	SpisakKlijenata() {}

	SpisakKlijenata(int maxBrojKlijenata) {
		this.setMaxBrojKlijenata(maxBrojKlijenata);
		this.setTrenutniBrojKlijenata(0);
		this.nazivKlijenta = new String[maxBrojKlijenata];
	}

	public int getTrenutniBrojKlijenata() {
		return trenutniBrojKlijenata;
	}

	public void setTrenutniBrojKlijenata(int trenutniBrojKlijenata) {
		this.trenutniBrojKlijenata = trenutniBrojKlijenata;
	}

	public int getMaxBrojKlijenata() {
		return maxBrojKlijenata;
	}

	public void setMaxBrojKlijenata(int maxBrojKlijenata) {
		this.maxBrojKlijenata = maxBrojKlijenata;
	}	

	public void dodajKlijenta(String nazivKlijenta) {
		if (this.trenutniBrojKlijenata < this.maxBrojKlijenata) {
			this.nazivKlijenta[this.trenutniBrojKlijenata++] = nazivKlijenta;
			System.out.println("Uspesno dodat klijent: " + nazivKlijenta);
		} else {
			System.out.println("Nema vise mesta u spisku klijenata");
		}
	}

	public String nadjiKlijenta(String nazivKlijenta) {		
		for (int i = 0; i < this.trenutniBrojKlijenata; i++) {
			if (this.nazivKlijenta[i].equals(nazivKlijenta)) {
				return this.nazivKlijenta[i];
			}
		}
		return ("Klijent nije pronadjen");
	}
}
