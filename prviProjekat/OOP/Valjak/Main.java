package Valjak;

public class Main {

	public static void main(String[] args) {

//		Valjak cev = new Valjak(2.0f, 200.0f);
		Valjak cev = new Valjak();
		cev.r = 2.0f;
		cev.H = 200.0f;

		System.out.println("Poluprecnik: " + cev.r);
		System.out.println("Visina: " + cev.H);
	}
}
