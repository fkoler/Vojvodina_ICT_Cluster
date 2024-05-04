package Fakultet;

public class Zaposleni extends Osoba {
	protected double koefRadnogMesta;
	protected double plata;
	
	public Zaposleni() {}

	public Zaposleni(
			String ime,
			String prezime,
			int starost,
			double koefRadnogMesta
			) {
		super(ime, prezime, starost);
		this.setKoefRadnogMesta(koefRadnogMesta);
		this.setPlatu(plata);
	}

	protected double getKoefRadnogMesta() {
		return this.koefRadnogMesta;
	}
	
	protected void setKoefRadnogMesta(double koefRadnogMesta) {
		this.koefRadnogMesta = koefRadnogMesta;
	}
    
    protected void setPlatu(double brojDana){
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
