package MaliFudbal;

public class KlasaTim {

	private String ime;
	private String grad;
	private int brojIgraca;	

	// Konstruktor
	public KlasaTim() {}
	
	public KlasaTim(
			String ime,
			String grad,
			int brojIgraca
		) {
		this.setIme(ime);
		this.setGrad(grad);
		this.setBrojIgraca(brojIgraca);
	}

	// Get metode
	public String getIme() {
		return ime;
	}

	public String getGrad() {
		return grad;
	}

	public int getBrojIgraca() {
		return brojIgraca;
	}	

	// Set metode
	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public void setBrojIgraca(int brojIgraca) {
		this.brojIgraca = brojIgraca;
	}

	// Metoda za prikaz informacija o timu
	@Override
	public String toString() {
		return String.format(
				"Tim: " + ime + ", Grad: " + grad 
				+ ", Broj igrača: " + brojIgraca
		);
	}
}
