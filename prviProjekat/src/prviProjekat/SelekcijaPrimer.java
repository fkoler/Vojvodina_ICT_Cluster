package prviProjekat;

public class SelekcijaPrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Unesite neki ceo broj: ");
		int x = TextIO.getlnInt();

//		if (x >= 0) 
//			System.out.println("Jeste");
//			
//		System.out.println("Mozda nije");

		if (x == 0)
			System.out.println("0");
			else
				if (x == 1)
				System.out.println("1");
			else 
				if (x == 2)
				System.out.println("2");
			else
				System.out.println("Nista Od Toga");

	}
}
