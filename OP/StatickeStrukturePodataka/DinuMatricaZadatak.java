package StatickeStrukturePodataka;

public class DinuMatricaZadatak {

	public static void main(String[] args) {

		int Nvr = 2;
		int Nkol = 3;
		int i = 0, j = 0;
		float srvr = 0;

		System.out.println("Program za racunanje srednje vrednosti elemenata matrice prirodnih brojeva.\n\n");
		System.out.println("Unesite broj vrsta:\t"); // prihvati broj vrsta i kolona
		Nvr = TextIO.getlnInt();
		System.out.println("\nUnesite broj kolona:\t");
		Nkol = TextIO.getlnInt();

		int[][] MatricaPrirordnihBrojeva = new int[Nvr][Nkol];
		int[] sumaPoVrsti = new int[Nvr];
		int[] sumaPoKoloni = new int[Nkol];

		for (i = 0; i < Nvr; i++) // prihvati elemente matrice od korisnika
			for (j = 0; j < Nkol; j++) {
				System.out.println("Unesite element matrice na koordinati [" + (i + 1) + "][" + (j + 1) + "]:\t");
				MatricaPrirordnihBrojeva[i][j] = TextIO.getlnInt();
			}

		System.out.println("M = ");
		for (i = 0; i < MatricaPrirordnihBrojeva.length; i++) {
			System.out.print("     ");
			for (j = 0; j < MatricaPrirordnihBrojeva[0].length; j++)
				System.out.print(MatricaPrirordnihBrojeva[i][j] + " ");
			System.out.println();
		}

		for (i = 0; i < Nvr; i++) // izracunaj sumu elemenata matrice
			for (j = 0; j < Nkol; j++)
				srvr += MatricaPrirordnihBrojeva[i][j];
		srvr /= (Nvr * Nkol); // izracunaj srednju vrednost elemenata matrice
		System.out.println(" Srednja vrednost elemenata matrice iznosi " + srvr + ".");

		// sume elemenata matrice po vrstima
		for (i = 0; i < Nvr; i++)
			for (j = 0; j < Nkol; j++)
				sumaPoVrsti[i] += MatricaPrirordnihBrojeva[i][j];

		System.out.print("SumaPoVrstama=[");
		for (i = 0; i < sumaPoVrsti.length - 1; i++) {
			System.out.print(sumaPoVrsti[i] + ", ");
		}
		System.out.print(sumaPoVrsti[sumaPoVrsti.length - 1] + "]");

//		==========================================		
		// sume elemenata matrice po koloni
		for (j = 0; j < Nkol; j++)
			for (i = 0; i < Nvr; i++)
				sumaPoKoloni[j] += MatricaPrirordnihBrojeva[i][j];

		System.out.print(", SumaPoKolonama=[");
		for (i = 0; i < sumaPoKoloni.length - 1; i++) {
			System.out.print(sumaPoKoloni[i] + ", ");
		}
		System.out.print(sumaPoKoloni[sumaPoKoloni.length - 1] + "]");		
//		==========================================
	}
}
