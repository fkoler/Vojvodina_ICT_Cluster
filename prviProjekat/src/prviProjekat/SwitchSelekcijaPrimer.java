package prviProjekat;

public class SwitchSelekcijaPrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Unesite zeljeni smer kretanja (0 - 3):");

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
