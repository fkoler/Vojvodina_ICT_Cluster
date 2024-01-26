package prviProjekat;

public class SwitchSelekcijaPrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int status;
		String potez = "nije pomerio";
		status = TextIO.getlnInt();
		switch (status) {
		case 0:
			potez = "pomerio gore";
			break;
		case 1:
			potez = "pomerio dole";
			break;
		case 2:
			potez = "pomerio levo";
			break;
		case 3:
			potez = "pomerio desno";
		}
		System.out.println("Igrac se " + potez); // Greska!
	}

}
