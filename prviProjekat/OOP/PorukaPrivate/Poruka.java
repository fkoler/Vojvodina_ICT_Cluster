package PorukaPrivate;

public class Poruka {
	private String tekst;

	public void postaviTekst(String tekst) {
		this.tekst = tekst;
	}

	private String pribaviTekst() {
		return this.tekst;
	}

	public void prikaziPoruku() {
		System.out.println(pribaviTekst());
	}
}
