package ElektronskoPoslovanje;

public class Zaposleni extends Osoba {   
    private double koefRadnogMesta;
    private double plata;  

    public Zaposleni(String ime, String prezime, int starost, double koefRadnogMesta) {       	
    	super(ime, prezime, starost);
		this.koefRadnogMesta = koefRadnogMesta;
		this.plata = 0;
	}      
         
    protected double pribaviKoefRadnogMesta() {
		return this.koefRadnogMesta;
	}
	
	protected void postaviKoefRadnogMesta(double koefRadnogMesta) {
		this.koefRadnogMesta = koefRadnogMesta;
	}
    
    protected void postaviPlatu(int brojDana){
    	plata = koefRadnogMesta * brojDana;
    }
    
    protected double pribaviPlatu() {
    	return this.plata;
    }
    
    public void stampajPlatu() {
        System.out.println(
        		getIme() + " " + getPrezime() + 
        		", na radnom mestu sa koeficijentom " 
        		+ pribaviKoefRadnogMesta() + 
        		" ima platu " + pribaviPlatu() +".");
    }
}
