package prviProjekat;

public class UlazIzlazVezba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int broj; // Broj koji treba da unese korisnik.
		int kvadrat; // Uneti broj pomnozen samim sobom - kvadrat broja.
		System.out.print("Unesite neki ceo broj: ");
		broj = TextIO.getlnInt();
		kvadrat = broj * broj;
		System.out.println();
		System.out.println("Broj koji ste uneli je " + broj);
		System.out.println("Kvadrat unetog broja je " + kvadrat);
		System.out.println();
	}
}
