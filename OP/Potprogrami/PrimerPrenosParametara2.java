package Potprogrami;

public class PrimerPrenosParametara2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] intNiz = { 1, 2, 3 };
		promeniNiz(intNiz);

		System.out.println("Vrednost niza nakon povratka u main: ");
		System.out.print(" [" + intNiz[0] + "," + intNiz[1] + "," + intNiz[2] + "]");
		System.out.println();
	}

	static void promeniNiz(int[] intNizPar) {

		int i = 0;

		System.out.println("Vrednost niza koji stize u potprogram: ");
		System.out.print(" [" + intNizPar[0] + "," + intNizPar[1] + "," + intNizPar[2] + "]");
		System.out.println();

		for (i = 0; i < 3; i++)
			intNizPar[i]++;

		System.out.println("Vrednost niza nakon uvecanja u potprogram: ");
		System.out.print(" [" + intNizPar[0] + "," + intNizPar[1] + "," + intNizPar[2] + "]");
		System.out.println();
	}
}
