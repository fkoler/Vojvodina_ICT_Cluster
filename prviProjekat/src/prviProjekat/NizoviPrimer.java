package prviProjekat;

public class NizoviPrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] mojNiz = new int[10];
		int[] mojNiz1 = new int[] { 1, 2, 3, 4, 5 };

		int n = 4;

		System.out.println(mojNiz1[4]);

		mojNiz[0] = 11;

		System.out.println(mojNiz[0]);

		mojNiz = new int[n];
		// adresa_treceg = adresa_prvog + index_treceg * sizeof_tipa

		for (int i = 0; i < mojNiz.length; i++) {
			System.out.println("niz[" + (i + 1) + "]");
			mojNiz[i] = TextIO.getlnInt();
		}
		System.out.print("niz[");
		for (int i = 0; i < mojNiz.length-1; i++) {
			System.out.print(mojNiz[i]+", ");
		}
		System.out.print(mojNiz[mojNiz.length-1]+"]");	
		
	}
}
