package FabrikaAutomobila;

public class Main {

	public static void main(String[] args) {

		FabrikaAutomobila fabrikaAutomobila = new FabrikaAutomobila();
		
		Automobil a1 = fabrikaAutomobila.napraviAutomobil("bmw");
		
		a1.napravi();
		
		Automobil a2 = fabrikaAutomobila.napraviAutomobil("mercedes");
		
		a2.napravi();
		
		Automobil a3 = fabrikaAutomobila.napraviAutomobil("fiat");
		
		a3.napravi();
	}
}
