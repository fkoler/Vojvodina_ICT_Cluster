package GenerisanjeIzuzetka;

import java.io.IOException;

public class Main2 {

	public static void main(String[] args) throws IOException {

		double a = 0.1, b = 8.0, c = -9.7;
		double d = koren(a, b, c);
		
		try {			
			System.out.println( "Koren je: " + d);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {					
			System.out.println("Pozdrav iz finally bloka");
		}
	}
	
	static public double koren(double A, double B, double C) {
		assert A != 0 : "Vodeci koeficijent kvadratne jednacine	ne sme biti nula!";
		double disk = B * B - 4 * A * C;
		assert disk >= 0 : "Diskriminanta kvadratne jednacine ne sme biti negativna!";		
		return (-B + Math.sqrt(disk)) / (2 * A);
	}
}
