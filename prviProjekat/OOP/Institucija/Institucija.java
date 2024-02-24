package Institucija;

public class Institucija {	
	
	private static final int maxBroj = 20;
	private String naziv, adresa, maticniBroj;
	private Zaposleni zakonskiZastupnik;
	private Ucionica[] spisakUcionica;
	private Zaposleni[] spisakZaposlenih;
	private int brojUcionica, brojZaposlenih;
	
	public Institucija() {}

	public Institucija(
			String naziv,
			String adresa,
			String maticniBroj,
			Zaposleni zakonskiZastupnik
			) {
		this.setNaziv(naziv);
		this.setAdresa(adresa);
		this.setMaticniBroj(maticniBroj);
		this.setZakonskiZastupnik(zakonskiZastupnik);
		this.spisakUcionica = new Ucionica[maxBroj];
		this.brojUcionica = 0;
		this.spisakZaposlenih = new Zaposleni[maxBroj];
		this.brojZaposlenih = 0;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public Zaposleni getZakonskiZastupnik() {
		return zakonskiZastupnik;
	}

	public void setZakonskiZastupnik(Zaposleni zakonskiZastupnik) {
		this.zakonskiZastupnik = zakonskiZastupnik;
	}

	public Ucionica[] getSpisakUcionica() {
		return spisakUcionica;
	}

	public void setSpisakUcionica(Ucionica[] spisakUcionica) {
		this.spisakUcionica = spisakUcionica;
	}

	public Zaposleni[] getSpisakZaposlenih() {
		return spisakZaposlenih;
	}

	public void setSpisakZaposlenih(Zaposleni[] spisakZaposlenih) {
		this.spisakZaposlenih = spisakZaposlenih;
	}

	public int getBrojUcionica() {
		return brojUcionica;
	}

	public void setBrojUcionica(int brojUcionica) {
		this.brojUcionica = brojUcionica;
	}	

	public int getBrojZaposlenih() {
		return brojZaposlenih;
	}

	public void setBrojZaposlenih(int brojZaposlenih) {
		this.brojZaposlenih = brojZaposlenih;
	}
	

	public boolean dodajUcionicu(String oznaka, String tip, int brMesta, double povrsina, boolean racunarska) {
		if (this.brojUcionica == maxBroj)
			return false;
		//if (racunarska) {
		//	spisakUcionica[brojUcionica++] = new RacunarskaUcionica(oznaka, tip, brMesta, povrsina);
		//}
		//else {
		spisakUcionica[brojUcionica] = new Ucionica(oznaka, tip, brMesta, povrsina);
		this.brojUcionica++;
		//}
		return true;
	}
	
	public boolean dodajZaposlenog(String ime, String prezime, int starost, double koefRadnogMesta) {
		if (brojZaposlenih == maxBroj)
			return false;
		spisakZaposlenih[brojZaposlenih++] = new Zaposleni(ime, prezime, starost, koefRadnogMesta);
		return true;
	}
	
	public void prikaziPodatke() {
		System.out.println(this.toString());
		System.out.println("Spisak zaposlenih: ");
		for (int i = 0; i < brojZaposlenih; i++)
			System.out.println(this.spisakZaposlenih[i]);
		System.out.println("Spisak ucionica: ");
		for (int i = 0; i < brojUcionica; i++)
			System.out.println(this.spisakUcionica[i]);
	}
}
