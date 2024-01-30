package UpravljackeStrukture;

import prviProjekat.TextIO;

public class SwitchSelekcijaPrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Unesite zeljeni smer kretanja (a-levo, s-dole, d-desno, w-gore)");

		String status;
		String potez;
		status = TextIO.getlnString();

		switch (status) {
		case "w":
			potez = "pomerio gore";
			break;
		case "s":
			potez = "pomerio dole";
			break;
		case "a":
			potez = "pomerio levo";
			break;
		case "d":
			potez = "pomerio desno";
			break;
		default:
			potez = "nije pomerio";
		}
		System.out.println("Igrac se " + potez);
	}
}
