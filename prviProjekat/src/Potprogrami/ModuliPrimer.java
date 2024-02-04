package Potprogrami;

import prviProjekat.TextIO;

public class ModuliPrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double x = sabiranje(5, 8);

		int k = 3;

		double l = 4.5;

		System.out.println(x);

		double z = mnozenje(k, l);

		prikaziPoruku(Double.toString(z));
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

	static void prikaziPoruku(String str) {

		System.out.println(str);
	}

}
