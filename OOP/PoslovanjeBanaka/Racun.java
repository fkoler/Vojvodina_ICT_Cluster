package PoslovanjeBanaka;

public class Racun {

	protected float stanje;
	protected boolean aktivan;
	protected String valuta;

	public Racun() {}

	public Racun(float stanje, boolean aktivan, String valuta) {
		this.setStanje(stanje);
		this.setAktivan(aktivan);
		this.setValuta(valuta);
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public float getStanje() {
		return stanje;
	}

	public void setStanje(float stanje) {
		this.stanje = stanje;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}
}
