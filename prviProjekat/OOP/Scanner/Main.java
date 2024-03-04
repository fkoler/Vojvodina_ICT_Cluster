package Scanner;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite Vas JMBG: ");
		String jmbg = sc.next();
		System.out.println("Unesite Vase ime: ");
		String ime = sc.next();
		System.out.println("Unesite Vasu platu: ");
		double plata = sc.nextDouble();
		System.out.println(
				"JMBG: <" + jmbg + "> Ime: <" + ime + "> Plata: <" + plata + ">"
				);
		sc.close();
	}
}
