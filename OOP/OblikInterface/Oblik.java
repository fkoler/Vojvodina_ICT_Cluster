package OblikInterface;

public class Oblik {

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
}
