package Programer;

public abstract class Biljka {
	
	// Atributi
    protected String naziv;
    protected String familija;
    protected boolean visegodisnja;

    // Konstruktor
    public Biljka() {}
    
    public Biljka(
    		String naziv,
    		String familija,
    		boolean visegodisnja
    	) {
        this.setNaziv(naziv);
        this.setFamilija(familija);
        this.setVisegodisnja(visegodisnja);
    }
    
 // Apstraktne metode
    public abstract void sadjenje();
    public abstract void prihranjivanje();

    // Geteri i seteri
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getFamilija() {
        return familija;
    }

    public void setFamilija(String familija) {
        this.familija = familija;
    }

    public boolean isVisegodisnja() {
        return visegodisnja;
    }

    public void setVisegodisnja(boolean visegodisnja) {
        this.visegodisnja = visegodisnja;
    }    
}