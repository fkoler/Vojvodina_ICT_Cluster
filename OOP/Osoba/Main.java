package Osoba;

public class Main {

	public static void main(String[] args) {
		/*
		Osoba o1 = new Osoba("Petar", "Petrovic", 35);
		Osoba o2 = new Osoba("Ivana", "Ivanovic", 32);

		Zaposleni z1 = new Zaposleni("Adam", "Adamovic", 39, 2600);
		Zaposleni z2 = new Zaposleni("Jovana", "Jovanovic", 28, 2900);

		o1.predstaviSe();
		o2.predstaviSe();

		z1.predstaviSe();
		z2.predstaviSe();

		z1.postaviPlatu(19);
		z1.stampajPlatu();

		z2.postaviPlatu(19);
		z2.stampajPlatu();
		/*
		/*
		
		Student s1 = new Student("Marko", "Markovic", 21, 10482, 25.5, 28.7);
		Student s2 = new Student("Marina", "Marinovic", 20, 10505, 28.8, 30.5);

		s1.predstaviSe();
		s2.predstaviSe();

		s1.racunajPoene();
		s2.racunajPoene();

		s1.stampajPoene();
		s2.stampajPoene();
		*/
		
		Klijent k1 = new Klijent("Mirko", "Mirkovic", 21, "01234567", "Sremska, Novi Sad", 1000);
		Klijent k2 = new Klijent("Imenko", "Prezimic", 31, "11234567", "Banatska, Novi Sad", 2000);
	
		k1.stampajPodatke();
		k2.stampajPodatke();
		
		k2.izvrsiTransakciju(k1, 500, true);
		
		System.out.println();
		
		k1.stampajPodatke();
		k2.stampajPodatke();
	}
}
