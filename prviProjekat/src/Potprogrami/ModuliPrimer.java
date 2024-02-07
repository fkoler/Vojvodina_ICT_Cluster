package Potprogrami;

public class ModuliPrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double x = sabiranje(5, 8);
		int k = 3;
		double l = 4.5;

		System.out.println(x);

		double z = mnozenje(k, l);

		prikaziPoruku(Double.toString(z));

		ispisiNiz(noviNiz(4)); // metoda moze biti parametar druge metode
	}

	static int sabiranje(int a, int b) {

		int res = 0;

		res = a + b;

		return res;
	}

	static double sabiranje(double a, double b) {

		double res = 0;

		res = a + b;

		if (res > 0) {
			return res;
		} else {
			return -1 * res;
		}
	}

	static double mnozenje(int a, double b) {

		return a * b;
	}

	static void prikaziPoruku(String str) { // void: ne vraca vrednost

		System.out.println(str);
	}

	static int[] noviNiz(int n) {
		int[] x = new int[n];

		for (int i = 0; i < x.length; i++) {
			System.out.println("niz[" + (i + 1) + "]=");
			x[i] = TextIO.getlnInt();
		}
		return x;
	}

	static void ispisiNiz(int[] x) {
		System.out.print("niz=[");
		for (int i = 0; i < x.length - 1; i++) {
			System.out.print(x[i] + ", ");
		}
		System.out.print(x[x.length - 1] + "]");
	}
}
