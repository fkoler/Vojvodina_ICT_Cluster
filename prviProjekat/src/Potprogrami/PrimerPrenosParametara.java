package Potprogrami;

public class PrimerPrenosParametara {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int broj = 5;
		povecajBroj(broj);
		System.out.println("1. Vrednost broja nakon povratka u main: " + broj);
	}

	static void povecajBroj(int brojZaUvecavanje) {
		System.out.println("2. Vrednost broja koji stize u potprogram: " + brojZaUvecavanje);
		brojZaUvecavanje++;
		System.out.println("3. Vrednost broja nakon uvecanja u potprogramu: " + brojZaUvecavanje);
	}
}
