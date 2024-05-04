package Poruka;

public class Poruka {
	
	String tekst;

	void postaviTekst(String noviTekst) {
		
		tekst = noviTekst;
	}

	void pribaviTekst() {
		
		System.out.println(tekst);
	}
}
