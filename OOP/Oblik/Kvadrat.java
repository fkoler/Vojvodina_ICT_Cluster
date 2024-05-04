package Oblik;

public class Kvadrat extends Oblik {

	protected double duzinaStranice;

	public Kvadrat() {}

	public Kvadrat(String boja, String tip, double duzinaStranice) {
		super(boja, tip);
		this.setDuzinaStranice(duzinaStranice);
	}

	public double getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setDuzinaStranice(double duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}

	public void obimKvadrata() {
		this.setObim(4 * this.getDuzinaStranice());
	}

	public void povrsinaKvadrata() {
		this.setPovrsina(this.getDuzinaStranice() * this.getDuzinaStranice());
	}

	public void showOblik() {
		System.out.printf(
	"Boja: <%s>, Tip: <%s>, Duzina stranice: <%.2f>, Obim: <%.2f> Povrsina: <%.2f> \n", 	this.getBoja(), this.getTip(), this.getDuzinaStranice(), this.getObim(), this.getPovrsina());
	}
}
