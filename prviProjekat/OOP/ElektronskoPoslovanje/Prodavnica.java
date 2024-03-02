package ElektronskoPoslovanje;

public abstract class Prodavnica implements Imenovanje  {

	protected String imeProdavnice;
	protected SpisakKlijenata spisakKlijenata;
	protected Zaposleni[] spisakZaposlenih;
	private float stanjeRacuna;

	Prodavnica() {}
	
	public Prodavnica(String imeProdavnice, int maxBrojKlijenata){
		this.setImeProdavnice(imeProdavnice);
		this.spisakKlijenata = new SpisakKlijenata(maxBrojKlijenata);
	}
	

	public abstract String[] uzmiInventar();
	public abstract void kupiInventar(String artikal);

	public String getImeProdavnice() {
		return this.imeProdavnice;
	}
	
	public void setImeProdavnice(String ime) {
		this.imeProdavnice = ime;
	}

	public SpisakKlijenata getSpisakKlijenata() {
		return spisakKlijenata;
	}

	public void setSpisakKlijenata(SpisakKlijenata spisakKlijenata) {
		this.spisakKlijenata = spisakKlijenata;
	}
	
	public Zaposleni[] getSpisakZaposlenih() {
		return spisakZaposlenih;
	}
	
	public void setSpisakZaposlenih(Zaposleni[] spisakZaposlenih) {
		this.spisakZaposlenih = spisakZaposlenih;
	}
	
	public float getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(float stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}

	public void izracunajPDV() {
		System.out.println("Stopa PDV je 20%!");
	}
}
