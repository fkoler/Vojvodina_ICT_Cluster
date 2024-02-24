package Institucija;

public class Zaposleni extends Osoba {
	
	private double koefRadnogMesta;
	private double plata;
	
	public Zaposleni() {}

	public Zaposleni(String ime, String prezime, int starost, double koefRadnogMesta) {
		super(ime, prezime, starost);
		this.setKoefRadnogMesta(koefRadnogMesta);
		this.setPlatu(0);
	}

	protected double getKoefRadnogMesta() {
		return this.koefRadnogMesta;
	}
	
	protected void setKoefRadnogMesta(double koefRadnogMesta) {
		this.koefRadnogMesta = koefRadnogMesta;
	}
    
    protected void setPlatu(int brojDana){
    	this.plata = this.getKoefRadnogMesta() * brojDana;
    }
    
    protected double getPlatu() {
    	return this.plata;
    }

	public void stampajPlatu() {
		System.out.println(this.getIme() + " " + this.getPrezime() + ", na radnom mestu sa koeficijentom "
				+ this.getKoefRadnogMesta() + " ima platu " + this.getPlatu());
	}
}
