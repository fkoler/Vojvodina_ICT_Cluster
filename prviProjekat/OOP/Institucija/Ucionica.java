package Institucija;

public class Ucionica {
	
	protected String oznaka, tip;
	protected int brMesta;
	protected double povrsina;
	
	public Ucionica() {}	

	public Ucionica(
			String oznaka,
			String tip,
			int brMesta,
			double povrsina
			) {
		this.setOznaka(oznaka);
		this.setTip(tip);
		this.setBrMesta(brMesta);
		this.setPovrsina(povrsina);
	}	

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getBrMesta() {
		return brMesta;
	}

	public void setBrMesta(int brMesta) {
		this.brMesta = brMesta;
	}

	public double getPovrsina() {
		return povrsina;
	}

	public void setPovrsina(double povrsina) {
		this.povrsina = povrsina;
	}

	public String toString() {
		return oznaka + "(" + tip + "), broj mesta: " + brMesta + ", povrsina: " + povrsina + " m2";
	}
}
