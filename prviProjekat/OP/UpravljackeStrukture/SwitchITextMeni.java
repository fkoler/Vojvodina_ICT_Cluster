package UpravljackeStrukture;

public class SwitchITextMeni {

	public static void main(String[] args) {

		int opcija;

		System.out.println("Izaberite jednu od ponudjenih opcija?");
		System.out.println("\n\t1. Unos studenta");
		System.out.println("\n\t2. Izmena studenta");
		System.out.println("\n\t3. Brisanje studenta");
		System.out.println("\n\t4. Prikaz studenta");
		System.out.println();
		System.out.println("\n\tVas izbor je: ");

		opcija = TextIO.getlnInt();

		switch (opcija) {
		case 1:
			System.out.println("Izabrali ste prvu opciju.");
			break;
		case 2:
			System.out.println("Izabrali ste drugu opciju.");
			break;
		case 3:
			System.out.println("Izabrali ste trecu opciju.");
			break;
		case 4:
			System.out.println("Izabrali ste cetvrtu opciju.");
			break;
		default:
			System.out.println("Niste odabrali ni jednu od ponudjenih opcija");
			System.exit(1);
		}
	}
}
