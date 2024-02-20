package VoziloOsoba;

public class Main {

	public static void main(String[] args) {

		Osoba o1 = new Osoba("Petar", "Petrovic", 35);
		Osoba o2 = new Osoba("Ivana", "Ivanovic", 32);

		Vozilo v = new Vozilo("Opel", "Corsa", false, "benzin", 55, 1199, "NS021IT", 2004, o1);

		Automobil a = new Automobil("Opel", "Corsa", false, "benzin", 55, 1199, "NS021IT", 2004, o1, 5);
		Kamion k = new Kamion("Volvo", "FH", false, "dizel", 800, 5500, "NS021RS", 2016, o1, 3);
		Motocikl m = new Motocikl("Honda", "Rebel", false, "benzin", 22, 250, "ZA018RS", 1998, o1, false);

		v = a;

		v.stampajPodatke();
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

		a.pogonskiAgregat.stampajPodatke();
	}
}
