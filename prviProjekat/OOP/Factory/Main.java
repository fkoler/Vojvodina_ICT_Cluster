package Factory;

public class Main {

	public static void main(String[] args) {

		FabrikaOblika fabrikaOblika = new FabrikaOblika();
		// pribavi oblik Krug i pozovi njegov metod crtaj
		Figura oblik1 = fabrikaOblika.pribaviOblik("Krug");
		// pozovi metod crtaj za krug
		oblik1.crtaj();
		// pribavi oblik Pravougaonik i pozovi njegov metod crtaj
		Figura oblik2 = fabrikaOblika.pribaviOblik("pRAVOUGAONIK");
		// pozovi metod crtaj za pravougaonik
		oblik2.crtaj();
		// pribavi oblik Kvadrat i pozovi njegov metod crtaj
		Figura oblik3 = fabrikaOblika.pribaviOblik("KvAdRaT");
		// pozovi metod crtaj za kvadrat
		oblik3.crtaj();
	}
}
