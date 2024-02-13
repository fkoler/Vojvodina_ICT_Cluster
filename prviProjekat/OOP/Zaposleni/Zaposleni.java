package Zaposleni;

/* Kreirati klasu Zaposleni sa atributima ime (tipa
String), prezime (tipa String) i koefRadnogMesta
(tipa double), kao i metodama za postavljanje imena i
prezimena zaposlenog i postavljanje koeficijenta radnog
mesta, računanje plate po formuli plata = 3600 *
koefRadnogMesta i štampanje plate zaposlenog.
• Potom testirati klasu kreiranjem tri objekta u okviru
glavnog programa, kojima postavljamo imena i prezimena
i koeficijente radnog mesta i za koje potom računamo i
prikazujemo platu */

public class Zaposleni {

	String ime;
	String prezime;
	double koefRadnogMesta;
	double plata;

	void postaviIme(String i) {
		ime = i;
	}

	void postaviPrezime(String p) {
		prezime = p;
	}

	void racunanjePlate(double koef) {
		plata = 3600 * koef;
		System.out.println("Plata je: " + plata);
	}
}
