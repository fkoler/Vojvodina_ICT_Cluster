package prviProjekat;

public class ZapreminaKupe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double V = 0;
		
		double r = 2.0;

		double H = 6.0;
		
		final double PI = 3.14;
		
//		V = 1/3*r*r*H*PI;
		V = (r*r*H*PI) / 3;
		
		System.out.println("Zapremina kupe V je: " + V);
		
		double res = Math.cos(0.5);
		System.out.println(res);
	}

}
