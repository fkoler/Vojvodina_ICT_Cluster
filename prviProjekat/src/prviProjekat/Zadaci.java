package prviProjekat;

public class Zadaci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		double V = 0;
		
//		double r = 2.0;

//		double H = 4.0;
		
		final double PI = 3.14;
		
//		V = 1/3*r*r*H*PI;
//		V = r*r*H*PI/3;
		
//		System.out.println(V);
		
		
		
//		Drugi Zadatak
		
		double l = 30.0;
		double d = 0.01;
		double RCu = 1.588 * (10 - 8);
		
		double R = (RCu * 4 * l) / (d * d * PI);
		System.out.println("Otpornost je: " + R);
		
//		Treci Zadatak
		
		double n = 1;
		double p = 0;
		double V = 10;
		double T = 15;
		R = 8.314472;		
		
		p = (n * R * T) / V;
		System.out.println("Pritisak je: " + p);
		
//		Cetvrti Zadatak
		
		double valjak_r = 0.5;
		double valjak_H = 10;
		double valjak_A= 0;
		
		valjak_A = 2 * valjak_r * (valjak_r + valjak_H) * PI;
		
		System.out.println("Povrsina valjka je: " + valjak_A);
		
	}

}






















