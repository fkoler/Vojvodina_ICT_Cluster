package Osoba;

public class Klijent extends Osoba {

	private String jmbg;
	private String adresa;
	private double stanjeRacuna;

	public Klijent() {}

	public Klijent(
			String ime,
			String prezime,
			int starost, 
			String jmbg, 
			String adresa,
			double stanjeRacuna
			) {
		super(ime, prezime, starost);
		this.setJmbg(jmbg);
		this.setAdresu(adresa);
		this.setStanjeRacuna(stanjeRacuna);
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
		;
	}

	public String getJmbg() {
		return this.jmbg;
	}

	public void setAdresu(String adresa) {
		this.adresa = adresa;
	}

	public String getAdresu() {
		return this.adresa;
	}

	public void setStanjeRacuna(double stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}

	public double getStanjeRacuna() {
		return this.stanjeRacuna;
	}

	private void promeniStanjeRacuna(double iznosTransakcije, boolean isplata) {
		if (isplata) {
			if (iznosTransakcije > this.getStanjeRacuna()) {
				System.out.println("Transakcija nije moguca jer nema dovoljno sredstava na racunu!");
				return;
			} else {
				this.setStanjeRacuna(this.getStanjeRacuna() - iznosTransakcije);
			}
		} else {
			this.setStanjeRacuna(this.getStanjeRacuna() + iznosTransakcije);
		}
		return;
	}

	public void izvrsiTransakciju(Klijent k, int iznos, boolean isplata) {
		if (isplata) {
			this.promeniStanjeRacuna(iznos, true);
			k.promeniStanjeRacuna(iznos, false);
		} else {
			this.promeniStanjeRacuna(iznos, false);
			k.promeniStanjeRacuna(iznos, true);
		}
	}

	public void stampajPodatke() {
		System.out.println(getJmbg() + " " + this.getIme() + " " + this.getPrezime() + ", stanje racuna: "
				+ this.getStanjeRacuna());
	}
}
