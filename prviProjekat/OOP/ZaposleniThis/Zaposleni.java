package ZaposleniThis;

public class Zaposleni {

	private String ime, prezime;
	private int koefRadnogMesta, plata;
	private int faktor = 3600;
	
	Zaposleni(){}

	Zaposleni(String ime, String prezime, int koefRadnogMesta) {		
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setKoeficijent(koefRadnogMesta);
	}
	
	public void setIme(String ime) {		
		this.ime = ime;
	}

	public void setPrezime(String prezime) {		
		this.prezime = prezime;
	}

	public void setKoeficijent(int koefRadnogMesta) {		
		this.koefRadnogMesta = koefRadnogMesta;
	}
	
	public void racunanjePlate() {
		plata =  faktor * this.koefRadnogMesta;
	}

	public void ispisPlate() {
		System.out.println("Zaposleni: " + ime + " " + prezime);
		System.out.println("Koeficijent zaposlenog: " + koefRadnogMesta);
		System.out.println("Plata: " + plata);
	}
}
