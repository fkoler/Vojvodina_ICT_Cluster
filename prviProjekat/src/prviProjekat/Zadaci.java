package prviProjekat;

public class Zadaci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double V1 = 0;
		
		double r1 = 2.0;

		double H1 = 4.0;
		
		final double PI1 = 3.14;
		
		V1 = r1  *r1 * H1 * PI1 / 3;
		
		System.out.println(V1);
		
		
		
//		Drugi Zadatak
		
		double l = 30.0;
		double d = 0.01;
		double RCu = 1.588 / 100000000;
		
		double R = (RCu * 4 * l) / (d * d * PI1);
		System.out.println("Otpornost bakarnog kabla duzine " + l + " metara je: " + R + " oma");
		
//		Treci Zadatak
		
		double n = 1;
		double p = 0;
		double V = 3;
		double T = 273;
		R = 8.314471;		
		
		p = n * R * T / V;
		System.out.println("Pritisak idealnog gasa zapremine " + V + " metara kubnih pri temperaturi od: " + T + " Kelvina je: " + p);
		
//		Cetvrti Zadatak
		
		double valjak_r = 13;
		double valjak_H = 10;
		double valjak_A = 0;
		
		valjak_A = 2 * valjak_r * (valjak_r + valjak_H) * PI1;
		
		System.out.println("Povrsina valjka je poluprecnika " + valjak_r + " visine: " + valjak_H + " je: " + valjak_A);
		
	}

}






















