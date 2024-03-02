package ElektronskoPoslovanje;

public class Picerija extends Prodavnica implements Imenovanje {
	
	protected String[] ponudaHrane = {
			"Pica", "Pasta", "Salata", "Kalcona", "Sok", "Pivo" 
			};
	
	public Picerija() {}
	
	public Picerija(
			String spisakKlijenata,
			int maxBrojKlijenata, 
			String imeKompanije
			) {
		super(maxBrojKlijenata, imeKompanije);
	}

	public String[] uzmiInventar() {
		return ponudaHrane;
	}

	public void kupiInventar(String artikal) {
		System.out.println(
				"\nIz Picerije: "+ this.pribaviIme() +
				" ste narucili: " + artikal);
	}
	
	public String pribaviIme() {
		return this.imeKompanije;
	}	
	
	public void postaviIme(String ime) {
		this.imeKompanije = ime;
	}
}
