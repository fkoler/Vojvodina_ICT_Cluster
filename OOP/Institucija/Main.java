package Institucija;

public class Main {

	public static void main(String[] args) {
		
		Zaposleni z1 = new Zaposleni("Pera", "Peric", 45, 7.5);
		Institucija ftn = new Institucija("FTN", "Trg Dositeja Obradovica 6, Novi Sad", 		"123456", z1);
		
		ftn.dodajUcionicu("13", "laboratorija", 200, 200.0, false);
		
		ftn.prikaziPodatke();
	}
}
