package prviProjekat;

public class RacunanjeVremena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long vremePocetka; // Vreme pocetka rada programa u milisekundama.
		long vremeKraja; // Vreme kraja rada programa u milisekundama.
		double vreme; // Ukupno vreme trajanja programa.
		double sirina = 42.0, visina = 17.0, hipotenuza; // strane trougla
		vremePocetka = System.currentTimeMillis();
		hipotenuza = Math.sqrt(sirina * sirina + visina * visina);
		System.out.print("Pravougli trougao cije su stranice 42 i 17 ima hipotenuzu: ");
		System.out.println(hipotenuza);
		System.out.print("sin(1)*sin(1) + cos(1)*cos(1) - 1 je ");
		System.out.println(Math.sin(1) * Math.sin(1) + Math.cos(1) * Math.cos(1) - 1);
		System.out.print("Slucajno generisana vrednost: ");
		System.out.println(Math.random());
		System.out.print("Broj PI ima vrednost: ");
		System.out.println(Math.PI);
		vremeKraja = System.currentTimeMillis();
		vreme = (vremeKraja - vremePocetka) / 1000.0;
		System.out.print("Ukupno trajanje programa u sekundama je: ");
		System.out.println(vreme);
	}
}
