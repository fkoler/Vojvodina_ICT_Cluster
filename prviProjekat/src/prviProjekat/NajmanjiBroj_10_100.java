package prviProjekat;

public class NajmanjiBroj_10_100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N;
		int donji = -10;
		int gornji = 100;
		int broj;
		
		System.out.println("Unesite broj zeljenih brojeva koje zelite da poredite >>");
		N = TextIO.getlnInt();
		
		for( int i = 1; i <= N; i++ ){
			do {
				System.out.println("Unesite broj u opsegu od " + donji + " i " + gornji);
				broj = TextIO.getlnInt();
			} while ( broj > donji && broj < gornji );	
			
			System.out.println(broj);				
		}		
	}
}
