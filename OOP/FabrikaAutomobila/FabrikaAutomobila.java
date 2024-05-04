package FabrikaAutomobila;

public class FabrikaAutomobila {

	public Automobil napraviAutomobil(String tipAutomobila) {
		if (tipAutomobila == null) {
			return null;
		}
		if (tipAutomobila.equalsIgnoreCase("BMW")) {
			return new BMW();
		} else if (tipAutomobila.equalsIgnoreCase("MERCEDES")) {
			return new Mercedes();
		} else if (tipAutomobila.equalsIgnoreCase("FIAT")) {
			return new Fiat();
		}
		return null;
	}
}
