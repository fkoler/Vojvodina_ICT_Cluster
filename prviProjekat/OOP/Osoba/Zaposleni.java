package Osoba;

public class Zaposleni extends Osoba {
	private double koefRadnogMesta;
	private double plata;

	Zaposleni(String ime, String prezime, int starost, double koefRadnogMesta) {
		super(ime, prezime, starost);
		this.koefRadnogMesta = koefRadnogMesta;
	}

	public void racunajPlatu(int brojDana) {
		plata = koefRadnogMesta * brojDana;
	}

	public void postaviPlatu(int brojDana) {
		plata = koefRadnogMesta * brojDana;
	}

	public void stampajPlatu() {
		System.out.println(getIme() + " " + getPrezime() + ", na radnom mestu sa koeficijentom "
				+ pribaviKoefRadnogMesta() + " ima platu " + pribaviPlatu());
	}
}
