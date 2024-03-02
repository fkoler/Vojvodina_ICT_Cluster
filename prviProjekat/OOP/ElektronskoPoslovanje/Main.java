package ElektronskoPoslovanje;

public class Main {

	public static void main(String[] args) {

		Poslasticarnica CariGrad = new Poslasticarnica("CariGrad", 40);
		Picerija Toscana = new Picerija("Toscana", 95);	
		
		CariGrad.spisakKlijenata.dodajKlijenta("Djura Djuric");
		Toscana.spisakKlijenata.dodajKlijenta("Pera Peric");
		
		System.out.println(CariGrad.spisakKlijenata.nadjiKlijenta("Djura Djuricic"));
		System.out.println(Toscana.spisakKlijenata.nadjiKlijenta("Pera Pericic"));

		CariGrad.kupiInventar("Krempita");
		Toscana.kupiInventar("Pasta alla Genovese");		
	}
}
