package Potprogrami;

import java.util.regex.Pattern;

public class PotprogramiVezba4PolazniciJMBG_Ivan {

	/*
	 * VEŽBA4: Modifikovati prethodnu vežbu tako da korisnik može da bira kriterijum
	 * po kojem će se vršiti sortiranje. Implementirati program oslanjajući se na
	 * funkcije.
	 */

	public static void main(String[] args) {

		final int MAXPOLAZNIKA = 40;
		String[] jmbg = new String[MAXPOLAZNIKA];
		String[] ime = new String[MAXPOLAZNIKA];
		String[] prezime = new String[MAXPOLAZNIKA];
		String[] grad = new String[MAXPOLAZNIKA];
		int unetoPolaznika = 0;
		char meni;
		boolean odabranKriterijum;
		String kriterijum = "";

		System.out.println("*****************************************************");
		System.out.println("Program za unos i sortiranje polaznika po kriterijumu");
		System.out.println("*****************************************************");
		System.out.println();

		unetoPolaznika = unosPolaznika(MAXPOLAZNIKA, ime, prezime, grad, jmbg);
		System.out.println();
		System.out.println("Uneti spisak polaznika");
		System.out.println();

		stampaPolaznika(unetoPolaznika, ime, prezime, grad, jmbg);
		do {

			System.out.println("-----------------------------------------");
			System.out.println("Izaberite jednu od ponuđenih opcija:");
			System.out.println("0 <- Izlaz iz programa");
			System.out.println("1 <- Sortiraj po imenu");
			System.out.println("2 <- Sortiraj po prezimenu");
			System.out.println("3 <- Sortiraj po gradu");
			System.out.println("4 <- Sortiraj po JMBG-u");

			System.out.println("-----------------------------------------");
			System.out.print("Vaš izbor -> ");
			meni = TextIO.getlnChar();
			switch (meni) {
			case '0':
				odabranKriterijum = false;
				System.out.printf("Kraj rada.");
				break;
			case '1':
				odabranKriterijum = true;
				kriterijum = "ime";
				sortNizStrAsc(ime, prezime, grad, jmbg, unetoPolaznika); // Na prvom mestu se prosleđuje niz po kome se
																			// vrši sortiranje
				break;
			case '2':
				odabranKriterijum = true;
				kriterijum = "prezime";
				sortNizStrAsc(prezime, jmbg, ime, grad, unetoPolaznika); // Na prvom mestu se prosleđuje niz po kome se
																			// vrši sortiranje
			case '3':
				odabranKriterijum = true;
				kriterijum = "grad";
				sortNizStrAsc(grad, jmbg, ime, prezime, unetoPolaznika); // Na prvom mestu se prosleđuje niz po kome se
																			// vrši sortiranje
				break;
			case '4':
				odabranKriterijum = true;
				kriterijum = "JMBG";
				sortNizStrAsc(jmbg, ime, prezime, grad, unetoPolaznika); // Na prvom mestu se prosleđuje niz po kome se
																			// vrši sortiranje
				break;

			default:
				odabranKriterijum = false;
				System.out.println("GREŠKA!!! Molim vas da odaberete jednu od ponuđenih opcija!");
			}
			if (odabranKriterijum) { // Štapa se pokreće samo ako je korisnik odabrao kriterijum sortiranja
				System.out.println();
				System.out.println("Spisak polaznika posle sortiranja po kriterijumu " + kriterijum.toUpperCase());
				System.out.println();
				stampaPolaznika(unetoPolaznika, ime, prezime, grad, jmbg);
			}
		} while (meni != '0');
	}

	static int unosPolaznika(int maksimalanBroj, String[] ime, String[] prezime, String[] grad, String[] jmbg) {
		char novUnos = 'd';
		int uneto = 0;

		for (int i = 0; i < maksimalanBroj; i++) {
			System.out.println("Unos podataka za polaznika broj " + (i + 1));
			System.out.println("----------------------------------");
			System.out.print("Unesite ime -> ");
			ime[i] = TextIO.getln();
			System.out.print("Unesite prezime -> ");
			prezime[i] = TextIO.getln();
			System.out.print("Unesite grad -> ");
			grad[i] = TextIO.getln();
			jmbg[i] = unosJMBG();
			System.out.println("----------------------------------");
			uneto++; // Može i da stoji uneto = i + 1;
			if (uneto <= maksimalanBroj) {
				System.out.print(
						"Unesite d za unos novog polaznika. Za prekid unosa unesite bilo koji drugi karakter -> ");
				novUnos = TextIO.getlnChar();
				if (novUnos != 'd') {
					System.out.println("Prekidam unos");
					break; // Izlaz iz for petlje za unos
				} else
					System.out.println();
			} else {
				System.out.println("Uneli ste maksimalan broj polaznika! Prekidam unos");
			}
		}

		return uneto;
	}

	static String unosJMBG() {
		boolean uslov;
		String unetJMBG = "";
		// Dok se ne zadovolji uslov traži se ponovni unos na tastaturi
		do {
			System.out.print("Unesite JMBG -> ");
			unetJMBG = TextIO.getln();
			uslov = Pattern.matches("[0-9]{13}", unetJMBG);
			if (!uslov) {
				System.out.println(
						"Uneti JMBG nije u očekivanom formatu!\n" + "JMBG je podatak koji se sastoji iz 13 cifara");
			}
		} while (!uslov);
		return unetJMBG;
	}

	static void stampaPolaznika(int brojPolaznika, String[] ime, String[] prezime, String[] grad, String[] jmbg) {
		String kolone = "|%15s |%15s |%15s |%15s |\n";
		System.out.printf(kolone, "Ime", "Prezime", "Grad", "JMBG");
		for (int i = 0; i < brojPolaznika; i++)
			System.out.printf(kolone, ime[i], prezime[i], grad[i], jmbg[i]);
	}

	static void sortNizStrAsc(String[] A, String[] B, String[] C, String[] D, int brojClanovaNiza) {
		// Sortiranje se vrši po nizu koji je prosleđen kao niz A
		String tmp;
		for (int i = 0; i < (brojClanovaNiza - 1); i++)
			for (int j = i + 1; j < brojClanovaNiza; j++)
				if (A[i].compareTo(A[j]) > 0) {
					// Zamena pozicija niza A
					tmp = A[i];
					A[i] = A[j];
					A[j] = tmp;
					// Zamena pozicija niza B
					tmp = B[i];
					B[i] = B[j];
					B[j] = tmp;
					// Zamena pozicija niza C
					tmp = C[i];
					C[i] = C[j];
					C[j] = tmp;
					// Zamena pozicija niza D
					tmp = D[i];
					D[i] = D[j];
					D[j] = tmp;
				}
	}
}
