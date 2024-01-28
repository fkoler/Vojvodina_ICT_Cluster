package prviProjekat;

public class EnumISwitch {

	enum Dan {
		PONEDELJAK, UTORAK, SREDA, CETVRTAK, PETAK, SUBOTA, NEDELJA, NEISPRAVNO
	}

	public static void main(String[] args) {

		Dan danRodjenja;

		int unos;

		System.out.println("Unesite dan (1 - 7) >>");

		unos = TextIO.getlnInt();

		switch (unos) {
			case 1:
				danRodjenja = Dan.PONEDELJAK;
				break;
			case 2:
				danRodjenja = Dan.UTORAK;
				break;
			case 3:
				danRodjenja = Dan.SREDA;
				break;
			case 4:
				danRodjenja = Dan.CETVRTAK;
				break;
			case 5:
				danRodjenja = Dan.PETAK;
				break;
			case 6:
				danRodjenja = Dan.SUBOTA;
				break;
			case 7:
				danRodjenja = Dan.NEDELJA;
				break;
			default:
				danRodjenja = Dan.NEISPRAVNO;
				System.out.println("Vrednost je van opsega");
		}

		System.out.println("Uneli ste >> " + danRodjenja );
	}
}
