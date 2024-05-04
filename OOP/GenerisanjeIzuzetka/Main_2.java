package GenerisanjeIzuzetka;

import java.io.IOException;

public class Main_2 {

	public static void main(String[] args) throws IOException {

		double a = 10.1, b = 8.0, c = 70.7;

		System.out.println(koren(a, b, c));
	}

	static public double koren(double A, double B, double C) {
		assert A != 0 : "Vodeci koeficijent kvadratne jednacine	ne sme biti nula!";
		double disk = B * B - 4 * A * C;
		assert disk >= 0 : "Diskriminanta kvadratne jednacine ne sme biti negativna!";
		return (-B + Math.sqrt(disk)) / (2 * A);
	}
}
