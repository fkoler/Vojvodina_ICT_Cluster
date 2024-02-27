package OblikInterface;

public class Kvadrat extends Oblik implements Figura {

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

	public double racunajPovrsinu() {
		return this.duzinaStranice * this.duzinaStranice;
	}

	public double racunajObim() {
		return 4 * this.duzinaStranice;
	}

	public void showOblik() {
		System.out.printf(
		"Boja: <%s>, Tip: <%s>, Duzina stranice: <%.2f>, Obim: <%.2f> Povrsina: <%.2f> \n",
		this.getBoja(), this.getTip(), this.getDuzinaStranice(),
		racunajObim(), racunajPovrsinu());
	}
}
