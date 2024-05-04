package PoslovanjeBanaka;

public class Main {

	public static void main(String[] args) {

		Banka rajfajzen = new Banka();
		Klijent k1 = new Klijent("Dusan", "Gajic", "012234");
		Klijent k2 = new Klijent("Dinu", "Dragan", "102234");
		
		rajfajzen.getKlijenti().dodajKlijenta(k1);
		rajfajzen.getKlijenti().dodajKlijenta(k2);
		
		System.out.println(k1.getBrojRacuna().getStanje());
		System.out.println(k2.getBrojRacuna().getStanje());
		
		boolean uspesna = rajfajzen.izvrsiInternuTransakciju(k1, k2, 80);
		System.out.println("Uspesna transakcija: " + uspesna);
		
		System.out.println(k1.getBrojRacuna().getStanje());
		System.out.println(k2.getBrojRacuna().getStanje());
		
		rajfajzen.getKlijenti().upisiUFajl("OOP\\PoslovanjeBanaka\\klijenti.txt");
		
		rajfajzen.getKlijenti().obrisiKlijenta(k1);
		rajfajzen.getKlijenti().obrisiKlijenta(k2);
	}
}
