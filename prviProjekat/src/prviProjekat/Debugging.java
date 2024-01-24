package prviProjekat;

public class Debugging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Deklaracija promenljivih. */
		double investicija; // Vrednost investicije.
		double stopa; // Kamatana stopa.		
		investicija = 1000;
		stopa = 0.027;
		double zarada = investicija * stopa; // Compute the interest.
		investicija = investicija + zarada;
		// Izracunavanje investicije posle godinu dana sa kamatom.
		// (Obratiti paznju da nova vrednost investicije prepisuje staru.)
		/* Ispisivanje rezultata. */
		System.out.print("Za godinu dana zaradjeno je: ");
		System.out.print(zarada);
		System.out.println(" dinara.");
		System.out.print("Ukupna vrednost investije je sada: ");
		System.out.print(investicija);
		System.out.print(" dinara.");
	} // kraj main metode
} // kraj klas
