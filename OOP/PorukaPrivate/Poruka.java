package PorukaPrivate;

public class Poruka {
	private String tekst;

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	private String getTekst() {
		return this.tekst;
	}

	public void showPoruku() {
		System.out.println(this.getTekst());
	}
}
