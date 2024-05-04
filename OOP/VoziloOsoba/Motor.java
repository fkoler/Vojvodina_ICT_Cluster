package VoziloOsoba;

public class Motor {
	
	private boolean radi;   //pokrenut ili ne
	private String tip;   //dizel ili benzin
	private int snaga;    // snaga u kW
	private int kubikaza; // kubikaza u ccm
	
	public Motor() {}
	
	public Motor(boolean radi, String tip, int snaga, int kubikaza){
		this.setRadi(radi);
		this.setTip(tip);
		this.setSnaga(snaga);
		this.setKubikaza(kubikaza);
	}
	
	// radi
	public boolean getRadi() {
		return this.radi;
	}

	public void setRadi(boolean radi) {
		this.radi = radi;
	}

	// tip
	public String getTip() {
		return this.tip;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}

	// snaga
	public int getSnaga() {
		return this.snaga;
	}

	public void setSnaga(int snaga) {
		this.snaga = snaga;
	}

	// kubikaza
	public int getKubikaza() {
		return this.kubikaza;
	}

	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}

	// metode za pokretanje motora
	public void ukljuci() {
		this.setRadi(true);
	}

	public void iskljuci() {
		this.setRadi(false);	
	}
	
	public void stampajPodatke() {
		System.out.println("\nInformacije o motoru:");
		System.out.printf("Ukljucen: <%b>, Tip: <%s>, Snaga: <%d>,  Kubikaza: <%d> \n\n", 		this.getRadi(), this.getTip(), this.getSnaga(), this.getKubikaza());
	}
}
