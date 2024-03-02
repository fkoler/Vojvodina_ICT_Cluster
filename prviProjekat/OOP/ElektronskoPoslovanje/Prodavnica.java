package ElektronskoPoslovanje;

public abstract class Prodavnica {

	protected SpisakKlijenata spisakKlijenata;
	protected String imeKompanije;

	Prodavnica() {}
	
	Prodavnica(int maxBrojKlijenata, String imeKompanije){
		this.setSpisakKlijenata(spisakKlijenata);
		this.setImeKompanije(imeKompanije);
	}

	public String getImeKompanije() {
		return imeKompanije;
	}

	public void setImeKompanije(String imeKompanije) {
		this.imeKompanije = imeKompanije;
	}

	public SpisakKlijenata getSpisakKlijenata() {
		return spisakKlijenata;
	}

	public void setSpisakKlijenata(SpisakKlijenata spisakKlijenata) {
		this.spisakKlijenata = spisakKlijenata;
	}

	public abstract String[] uzmiInventar();

	public abstract void kupiInventar(String artikal);

	public void izracunajPDV() {
		System.out.println("Stopa PDV je 20%!");
	}
}
