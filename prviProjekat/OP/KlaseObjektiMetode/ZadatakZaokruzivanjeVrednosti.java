package KlaseObjektiMetode;

public class ZadatakZaokruzivanjeVrednosti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double No = -5.5514;
		
		double Absolut = Math.abs(No);		
		
		System.out.println("\nAbsolutna vrednost broja " + No + " je: " + Absolut);
		
		double Round = Math.round(No);
		
		System.out.println("\nZaokruzena vrednost broja " + No + " je: " + Round);
		
		System.out.println("\nZaokruzena i absolutna vrednost broja " + No + " je: " + Math.abs(Round));		
	}
}
