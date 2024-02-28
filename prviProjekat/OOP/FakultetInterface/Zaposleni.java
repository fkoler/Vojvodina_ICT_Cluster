package FakultetInterface;

public abstract class Zaposleni extends Osoba implements IPlata {
	
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
		this.setPlata(plata);
	}
	
	public abstract double racunajPlatu();
	public abstract void stampajPlatu();

	public double getKoefRadnogMesta() {
		return this.koefRadnogMesta;
	}
	
	public void setKoefRadnogMesta(double koefRadnogMesta) {
		this.koefRadnogMesta = koefRadnogMesta;
	} 
	

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}	
}
