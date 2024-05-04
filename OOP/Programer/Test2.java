package Programer;

public class Test2 {

	public static void main(String[] args) {
		// Ulazni niz celih brojeva
		int[] niz = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// Dva podniza za brojeve deljive sa 3 i one koji nisu deljivi sa 3
		int[] deljiviSa3 = new int[niz.length];
		int[] nisuDeljiviSa3 = new int[niz.length];
		int brojDeljivihSa3 = 0;
		int brojNedeljivihSa3 = 0;

		// Razdvajanje niza na dva podniza
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] % 3 == 0) {
				deljiviSa3[brojDeljivihSa3] = niz[i];
				brojDeljivihSa3++;
			} else {
				nisuDeljiviSa3[brojNedeljivihSa3] = niz[i];
				brojNedeljivihSa3++;
			}
		}

		// Ispisivanje sadržaja oba podniza
		System.out.println("Podniz sa brojevima deljivim sa 3:");
		for (int i = 0; i < brojDeljivihSa3; i++) {
			System.out.print(deljiviSa3[i] + " ");
		}
		System.out.println();

		System.out.println("Podniz sa brojevima koji nisu deljivi sa 3:");
		for (int i = 0; i < brojNedeljivihSa3; i++) {
			System.out.print(nisuDeljiviSa3[i] + " ");
		}
		System.out.println();
	}
}
