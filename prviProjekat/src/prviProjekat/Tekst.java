package prviProjekat;

public class Tekst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Djura Djuric";

		System.out.println(str);
		System.out.println(str.length());
		System.out.println(str.toUpperCase());

		System.out.println(str.equals("Djura Djuric"));
		System.out.println(str.equals("DjuraDjuric"));
		System.out.println(str.compareTo("Djura Djuric"));
		System.out.println(str.compareTo("DjuraDjuric "));
	}
}
