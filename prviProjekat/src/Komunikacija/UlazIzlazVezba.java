package Komunikacija;

import prviProjekat.TextIO;

public class UlazIzlazVezba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int broj; // Broj koji treba da unese korisnik.
		int kvadrat; // Uneti broj pomnozen samim sobom - kvadrat broja.

		System.out.print("Unesite neki ceo broj: ");

		broj = TextIO.getlnInt();
		kvadrat = broj * broj;
		
		System.out.println("\nBroj koji ste uneli je: " + broj);
		System.out.println("\nKvadrat unetog broja je: " + kvadrat);
		
	}
}
