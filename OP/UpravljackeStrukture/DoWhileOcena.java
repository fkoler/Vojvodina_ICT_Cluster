package UpravljackeStrukture;

public class DoWhileOcena {

	public static void main(String[] args) {

		int ocena;
		System.out.println("Program za ispis uspeha na osnovu unete ocene!");

		// do-while petlja se koristi da se proveri ulazna vrednost
		do {
			System.out.print("Unesite ocenu: ");
			ocena = TextIO.getlnInt();
			if ((ocena < 1) || (ocena > 5))
				System.out.println("Ocena mora biti izmedju 1 i 5.");
		} while ((ocena < 1) || (ocena > 5));

		switch (ocena) {
		case 1:
			System.out.println("Nedovoljan!");
			break;
		case 2:
			System.out.println("Dovoljan!");
			break;
		case 3:
			System.out.println("Dobar!");
			break;
		case 4:
			System.out.println("Vrlo dobar!");
			break;
		case 5:
			System.out.println("Odlican!");
		}
	}
}
