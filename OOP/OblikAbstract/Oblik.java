package OblikAbstract;

public abstract class Oblik {

	protected String boja, tip;
	protected int brojStrana;

	public Oblik() {}

	public Oblik(String boja, String tip) {
		this.setBoja(boja);
		this.setTip(tip);
	}
	
	public Oblik(String boja, String tip, int brojStrana) {
		this.setBoja(boja);
		this.setTip(tip);
	}
	
	public abstract double racunajObim();
	public abstract double racunajPovrsinu();	

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

	public void showOblik() {
		System.out.println(
			getBoja() + " " + getTip() + " " + getBrojStrana() + " " +
			racunajObim() + " " + racunajPovrsinu());
	}
}
