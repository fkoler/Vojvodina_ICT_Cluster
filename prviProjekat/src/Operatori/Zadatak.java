package Operatori;

public class Zadatak {

	public static void main(String[] args) {

		int a;
		int b;

		a = 8;
		b = 3;

		int sabiranje = a + b;
		int oduzimanje = a - b;
		int mnozenje = a * b;
		double deljenje = (double) a / b;
		int modulo = a % b;

		System.out.println(a + " + " + b + " = " + sabiranje);
		System.out.println(a + " - " + b + " = " + oduzimanje);
		System.out.println(a + " * " + b + " = " + mnozenje);
		System.out.println(a + " / " + b + " = " + deljenje);
		System.out.println(a + " % " + b + " = " + modulo);
	}
}
