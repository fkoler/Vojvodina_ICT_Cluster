package OblikAbstract;

public class Krug extends Oblik {

	protected double poluprecnik;

	Krug() {}

	Krug(String boja, String tip, double poluprecnik) {
		super(boja, tip);
		this.setPoluprecnik(poluprecnik);
	}

	public double getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(double poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

	public double racunajObim() {
		return (2 * this.getPoluprecnik() * Math.PI);
	}

	public double racunajPovrsinu() {
		return this.poluprecnik * this.poluprecnik * Math.PI;
	}

	public void showOblik() {
		System.out.printf(
		"Boja: <%s>, Tip: <%s>, Poluprecnik: <%.2f> Obim: <%.2f>, Povrsina: <%.2f> \n",
		this.getBoja(), this.getTip(), this.getPoluprecnik(),
		racunajObim(), racunajPovrsinu());
	}
}
