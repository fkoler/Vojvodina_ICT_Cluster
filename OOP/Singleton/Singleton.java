package Singleton;

public class Singleton {

	private static Singleton instanca = null;
	public String str;

	protected Singleton() {
		this.setStr("Pozdrav iz Singletona");
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public static Singleton pribaviInstancu() {
		if (instanca == null) {
			instanca = new Singleton();
		}
		return instanca;
	}
}
