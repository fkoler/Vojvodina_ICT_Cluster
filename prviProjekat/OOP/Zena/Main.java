package Zena;

public class Main {

	public static void main(String[] args) {
		
		Osoba o = new Osoba("Ivana", "Ivanovic", 32);
		Zena z = new Zena("Ivana", "Ivanovic", "Petrovic", 32);
		
		o.predstaviSe();
		z.predstaviSe();
	}
}
