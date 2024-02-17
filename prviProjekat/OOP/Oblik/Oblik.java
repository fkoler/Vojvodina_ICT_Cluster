package Oblik;

public class Oblik {

	protected String boja, tip;
	protected int brojStrana;
	protected double obim;
	protected double povrsina;
	

	public Oblik() {
	}

	public Oblik(String boja, String tip) {
		this.setBoja(boja);
		this.setTip(tip);
	}

	public Oblik(String boja, String tip, int brojStrana) {
		this.setBoja(boja);
		this.setTip(tip);
		this.setObim(obim);
		this.setPovrsina(povrsina);
	}	

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}
	
	public double getObim() {
		return obim;
	}

	public void setObim(double obim) {
		this.obim = obim;
	}

	public double getPovrsina() {
		return povrsina;
	}

	public void setPovrsina(double povrsina) {
		this.povrsina = povrsina;
	}

	public void showOblik() {
		System.out.printf("Boja: %s, Tip: %s, Broj Strana: %d", this.getBoja(), this.getTip(), this.getBrojStrana());
	}
}
