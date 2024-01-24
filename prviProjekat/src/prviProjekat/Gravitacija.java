package prviProjekat;

public class Gravitacija {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Deklaracija promenljivih. */
		double gravitacija = -9.81;
		double inicijalnoUbrzanje = 0.0;
		double vremePadanja = 10.0;
		double inicijalnaPozicija = 0.0;
		double finalnaPozicija = .5 * gravitacija * vremePadanja * vremePadanja;
		System.out.println("finalnaPozicija --> " + finalnaPozicija);
		
		/* Izracunavanje. */
		finalnaPozicija = finalnaPozicija + inicijalnoUbrzanje * vremePadanja;
		finalnaPozicija = finalnaPozicija + inicijalnaPozicija;
		
		/* Ispisivanje rezultata. */
		System.out.print("Pozicija objekta nakon ");
		System.out.print(vremePadanja);
		System.out.print(" sekundi je ");
		System.out.print(finalnaPozicija);
		System.out.print("m.");
	}
}
