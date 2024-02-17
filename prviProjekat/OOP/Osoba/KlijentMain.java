package Osoba;

public class KlijentMain {

	public static void main(String[] args) {
		
		Klijent k1 = new Klijent("Klijent1", "Prezime1", 45, 123980765, "Ulica 78", 167.80);
		Klijent k2 = new Klijent("Klijent2", "Prezime2", 31, 123345612, "Ulica 21", 598.60);

		k1.ispisiKlijenta();
		k2.ispisiKlijenta();
		
		System.out.println();
		
		k1.moneyTransfer(0, 0);
	}
}
