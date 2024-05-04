package GenerisanjeIzuzetka;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double a = 0.0, b = 8.0, c = 9.0, d;

		try {
			d = koren(a, b, c);
			System.out.println("Koren je: " + d);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Pozdrav iz finally bloka");
		}		
	}

	static public double koren(double A, double B, double C) throws IllegalArgumentException {
		if (A == 0) {
			throw new IllegalArgumentException("A ne može biti nula!");
		} else {
			double disk = B * B - 4 * A * C;
			if (disk < 0)
				throw new IllegalArgumentException("Diskriminanta manja od nule!");
			return (-B + Math.sqrt(disk)) / (2 * A);
		}
	}
}
