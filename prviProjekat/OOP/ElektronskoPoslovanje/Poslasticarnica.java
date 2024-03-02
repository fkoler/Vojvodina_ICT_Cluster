package ElektronskoPoslovanje;

public class Poslasticarnica extends Prodavnica implements Imenovanje {
	
	protected String[] stavkaMenija = {
			"Sladoled", "Torta", "Krofna", "Kafa", "Caj", "Limunada" 
			};

	public Poslasticarnica() {}

	public Poslasticarnica(
			String spisakKlijenata,
			int maxBrojKlijenata, 
			String imeKompanije
			) {
		super(maxBrojKlijenata, imeKompanije);
	}

	public String[] uzmiInventar() {
		return stavkaMenija;
	}

	public void kupiInventar(String artikal) {
		System.out.println(
				"\nIz Poslasticarnice: " + this.pribaviIme() +
				" ste narucili: " + artikal);
	}

	public String pribaviIme() {
		return this.imeKompanije;
	}	
	
	public void postaviIme(String ime) {
		this.imeKompanije = ime;
	}
}
