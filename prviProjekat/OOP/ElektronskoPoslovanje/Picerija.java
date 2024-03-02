package ElektronskoPoslovanje;

public class Picerija extends Prodavnica {
	
	protected String[] ponudaHrane = {
			"Pica", "Pasta", "Salata", "Kalcona", "Sok", "Pivo" 
			};
	
	public Picerija() {}
	
	public Picerija(String imeProdavnice, int maxBrojKlijenata){
		super(imeProdavnice, maxBrojKlijenata);
	}

	public String[] uzmiInventar() {
		return ponudaHrane;
	}

	public void kupiInventar(String artikal) {
		System.out.println(
				"\nIz Picerije: "+ this.getImeProdavnice() +
				" ste narucili: " + artikal);
	}
}
