package PorukaPrivate;

public class Main {

	public static void main(String[] args) {
		
		Poruka p = new Poruka();
		
		// p.tekst = "Zdravo svete!“; greska!	
		p.setTekst("Zdravo OOP svete!");
		p.showPoruku();
	}
}
