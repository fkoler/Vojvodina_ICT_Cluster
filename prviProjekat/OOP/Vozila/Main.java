package Vozila;

public class Main {

	public static void main(String[] args) {

		Vozila prvi = new Vozila("Peugeot 307", "hecbek", "NS-12345", 2017, 190, 66);
		Vozila drugi = new Vozila("Renault Clio", "hecbek", "SU-54321", 2012, 160, 54);
		Vozila treci = new Vozila("VW Sharan", "van", "BP-09876", 2020, 230, 116);

		prvi.racunajVrednost();
		prvi.stampajVrednost();

		drugi.racunajVrednost();
		drugi.stampajVrednost();

		treci.racunajVrednost();
		treci.stampajVrednost();

		prvi.uporediVrednost(drugi);		
		drugi.uporediVrednost(treci);
		treci.uporediVrednost(prvi);		
	}
}
