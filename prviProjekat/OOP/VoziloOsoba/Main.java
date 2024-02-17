package VoziloOsoba;

public class Main {

	public static void main(String[] args) {

		Osoba o1 = new Osoba("Osoba1", "Prezime1", 38);
		Osoba o2 = new Osoba("Osoba2", "Prezime2", 37);

		Automobil a = new Automobil("Opel", "Corsa", "NS021IT", 2004, o1, 5);
		Kamion k = new Kamion("Volvo", "FH", "NS021RS", 2016, o1, 3);
		Motocikl m = new Motocikl("Honda", "Rebel", "ZA018RS", 1998, o1, false);
		
		a.stampajPodatke();
		k.stampajPodatke();
		m.stampajPodatke();
		
		System.out.println();
		
		a.prenosVlasnistva(o2);
		k.prenosVlasnistva(o2);
		m.prenosVlasnistva(o2);		
		
		a.stampajPodatke();
		k.stampajPodatke();
		m.stampajPodatke();
	}
}
