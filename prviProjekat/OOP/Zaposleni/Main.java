package Zaposleni;

public class Main {

	public static void main(String[] args) {

		Zaposleni radnik = new Zaposleni();

		String imeZaposlenog, prezimeZaposlenog;
		double koeficijentZaposlenog;

		do {
			System.out.println("Unesite ime zaposlenog:\t");
			imeZaposlenog = TextIO.getlnString();			
			
			System.out.println("Unesite prezime zaposlenog:\t");
			prezimeZaposlenog = TextIO.getlnString();
			
			System.out.println("Unesite koeficijent zaposlenog:\t");
			koeficijentZaposlenog = TextIO.getlnDouble();
			
			if(imeZaposlenog == "" || prezimeZaposlenog == "" ||                                       			     koeficijentZaposlenog == 0) {
				System.out.println("Molimo Vas unesite ispravne podatke");
			}
			
			radnik.postaviIme(imeZaposlenog);
			radnik.postaviPrezime(prezimeZaposlenog);
			radnik.postaviKoeficijent(koeficijentZaposlenog);			
			
		} while (imeZaposlenog == "" || prezimeZaposlenog == "" ||                                       			     koeficijentZaposlenog == 0);

		radnik.racunanjePlate();

		radnik.ispisPlate();
	}
}
