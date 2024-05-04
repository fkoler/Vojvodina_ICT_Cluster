package UpravljackeStrukture;

public class _Zadatak4DinuDragan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int brojStud = 0;
		int ocena = 0;
		int ukOcena = 0;
		double prosek = 0;

		do {
			do {
				System.out.println("Unesite sledeću ocenu:");
				ocena = TextIO.getlnInt();
				if (ocena < 5 || ocena > 10)
					System.out.println("GREŠKA! Ocena mora biti u rasponu od 5 do 10. Unesite ponovo.");
			} while (ocena < 5 || ocena > 10);

			ukOcena += ocena;
			brojStud++;

			System.out.println("Za izlazak iz programa pritisnite taster 0");
			ocena = TextIO.getlnInt();

		} while (ocena != 0);

		prosek = (double) ukOcena / brojStud;

		System.out.println("Ukupan broj izaslih studenata je " + brojStud);
		System.out.println("Prosecna ocena je " + prosek);

	}

}