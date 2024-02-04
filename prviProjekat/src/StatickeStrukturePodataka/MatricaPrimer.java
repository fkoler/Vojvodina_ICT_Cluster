package StatickeStrukturePodataka;

public class MatricaPrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		adr_1 + ind_vrste * broj * size_of_tipa + ind_kolone * size_of_tipa

		int indexVrste = 2, indexKolone = 3, i = 0, j = 0;

//		int[][] mojaMatrica = new int[2][3];
		int[][] mojaMatrica1 = new int[indexVrste][indexKolone];
		int[][] mojaMatrica2 = { { 1, 2, 3 }, { 4, 5, 6 } };

		System.out.println("mojaMatrica2 = ");
		
		for (i = 0; i < mojaMatrica2.length; i++) {
			System.out.print("                 ");
			for (j = 0; j < mojaMatrica2[0].length; j++)
				System.out.print(mojaMatrica2[i][j] + " ");
			System.out.println();
		}
		
		System.out.println("m2 = ");
		for (i = 0; i < mojaMatrica2.length; i++) {
			for (j = 0; j < mojaMatrica2[0].length; j++) {
				System.out.println("M1 [" + (i+1)+","+(j+1)+"]=");
			}
		}
	}
}
