package Osoba;

public class Main {

	public static void main(String[] args) {
		Zaposleni z1 = new Zaposleni("Petar", "Petrovic", 35, 3800);
		Zaposleni z2 = new Zaposleni("Ivana", "Ivanovic", 32, 3900);

		z1.predstaviSe();
		z2.predstaviSe();
		z1.racunajPlatu(22);
		z2.racunajPlatu(23);
		z1.stampajPlatu();
		z2.stampajPlatu();
	}
}
