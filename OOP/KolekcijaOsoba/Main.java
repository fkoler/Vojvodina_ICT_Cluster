package KolekcijaOsoba;

public class Main {

	public static void main(String[] args) {

		Spisak polaznici = new Spisak();

		polaznici.ucitajListu("OOP\\KolekcijaOsoba\\spisakPolaznika.txt");
		polaznici.stampajListu();
		
		polaznici.sortirajListu();		
		polaznici.stampajListu();
		
		polaznici.obrniListu();
		polaznici.stampajListu();
		polaznici.upisiListu("OOP\\KolekcijaOsoba\\uredjeniSpisak.txt");
	}
}
