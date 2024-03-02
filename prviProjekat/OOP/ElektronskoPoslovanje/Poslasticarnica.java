package ElektronskoPoslovanje;

public class Poslasticarnica extends Prodavnica {
	
	protected String[] stavkaMenija = {
			"Sladoled", "Torta", "Krofna", "Kafa", "Caj", "Limunada" 
			};

	public Poslasticarnica() {}

	public Poslasticarnica(String imeProdavnice, int maxBrojKlijenata){
		super(imeProdavnice, maxBrojKlijenata);
	}
	
	public String[] getMeni() {
		return stavkaMenija;
	}

	public void setMeni(String[] meni) {
		this.stavkaMenija = meni;
	}

	public String[] uzmiInventar() {
		return stavkaMenija;
	}
	
	public void kupiInventar(String artikal) {
		System.out.println(
				"\nIz Poslasticarnice: "+ this.getImeProdavnice() +
				" ste narucili: " + artikal);
	}
}
