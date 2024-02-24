package Oblik;

public class Krug extends Oblik {

	protected double poluprecnik;

	Krug() {}

	Krug(String boja, String tip, double poluprecnik) {
		super(boja, tip);
		this.poluprecnik = poluprecnik;
	}

	public double getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(double poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

	public void obimKruga() {
		this.setObim(2 * getPoluprecnik() * Math.PI);
	}

	public void povrsinaKruga() {
		this.setPovrsina(Math.PI * (2 * this.getPoluprecnik()));
	}

	public void showOblik() {
		System.out.printf(
	"Boja: <%s>, Tip: <%s>, Poluprecnik: <%.2f> Obim: <%.2f>, Povrsina: <%.2f> \n",
	this.getBoja(),	this.getTip(), this.getPoluprecnik(), this.getObim(), this.getPovrsina());
	}
}
