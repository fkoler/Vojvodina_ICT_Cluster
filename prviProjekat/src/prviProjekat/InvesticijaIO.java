package prviProjekat;

public class InvesticijaIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double investicija; // Vrednost investicije.
		double stopa; // Kamatana stopa.
		double zarada; // Ukupna kamata po godini.
		System.out.print("Unesite vrednost investicije: ");
		investicija = TextIO.getlnDouble();
		System.out.print("Unesite vrednost kamatne stope: ");
		stopa = TextIO.getlnDouble();
		zarada = investicija * stopa;
		investicija = investicija + zarada; // Izracunavanje zarade.
		System.out.println("Za godinu dana zaradjeno je: " + zarada + " dinara.");
		System.out.println("Ukupna vrednost investije je sada: " + investicija + " dinara.");
	}
}