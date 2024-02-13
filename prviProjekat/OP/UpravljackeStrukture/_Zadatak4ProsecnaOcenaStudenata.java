package UpravljackeStrukture;

public class _Zadatak4ProsecnaOcenaStudenata {

	public static void main(String[] args) {

		int brojStudenata = 0;
		int ocena = 0;
		int ukupnaOcena = 0;
		double prosek = 0;

		do {
			System.out.println("Unesite ocenu od 5 do 10, ili izadjite iz programa pritiskom na 0");
			ocena = TextIO.getlnInt();
			if (ocena == 0) {
				break;
			}
			do {
				if (ocena < 5 || ocena > 10)
					System.out.println("\n\tGRESKA! Ocena mora biti u rasponu od 5 do 10. Unesite ponovo.");
				break;
			} while (ocena < 5 || ocena > 10);

			ukupnaOcena += ocena;
			brojStudenata++;
			
		} while (ocena != 0);

		prosek = (double) ukupnaOcena / brojStudenata;
		
		if(brojStudenata == 0) {
			prosek = 0;
		}

		System.out.println("\n\tUkupan broj izaslih studenata je " + (brojStudenata));
		System.out.printf("\n\tProsecna ocena je %.2f", prosek);
	}
}
