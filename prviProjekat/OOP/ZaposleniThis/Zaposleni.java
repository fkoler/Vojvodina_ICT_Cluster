package ZaposleniThis;

public class Zaposleni {

	private String ime, prezime;
	private double koefRadnogMesta, plata;

	Zaposleni() {}

	Zaposleni(String ime, String prezime, double koefRadnogMesta) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setKoeficijent(koefRadnogMesta);
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getIme() {
		return this.ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setKoeficijent(double koefRadnogMesta) {
		this.koefRadnogMesta = koefRadnogMesta;
	}

	public double getKoeficijent() {
		return this.koefRadnogMesta;
	}
	
	public void racunanjePlate(int brojDana) {
		this.plata = brojDana * this.koefRadnogMesta * 100;
	}

	public void ispisPlate() {
		System.out.printf("Zaposleni: %s %s \n", getIme(), getPrezime());
		System.out.printf("Koeficijent zaposlenog: %.2f \n", getKoeficijent());
		System.out.printf("Plata: %.2f \n", plata);
	}
}
