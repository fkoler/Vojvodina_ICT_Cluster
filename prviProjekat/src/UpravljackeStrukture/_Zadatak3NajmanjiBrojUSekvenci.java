package UpravljackeStrukture;

import prviProjekat.TextIO;

public class _Zadatak3NajmanjiBrojUSekvenci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N;
		int donji = -10;
		int gornji = 100;
		int broj;
		int najmanjiBroj = 100;

		System.out.println("Unesite broj zeljenih brojeva koje zelite da poredite >>");
		N = TextIO.getlnInt();

		System.out.println("Unesite brojeve u opsegu od " + donji + " i " + gornji);

		for (int i = 1; i <= N; i++) {

			do {

				broj = TextIO.getlnInt();
				if (broj < donji || broj > gornji) {
					System.out.println("Uneta vrednost nije u zadatom opsegu");
					i--;
					break;
				}
				if (broj < najmanjiBroj) {
					najmanjiBroj = broj;
				}

			} while (broj < donji || broj > gornji);
		}

		System.out.println("Najmanji broj u sekvenci je: " + najmanjiBroj);
	}
}
