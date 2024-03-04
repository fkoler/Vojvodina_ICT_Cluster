package ElektronskoPoslovanje;

public class Main {

	public static void main(String[] args) {

		Prodavnica CariGrad = new Poslasticarnica("CariGrad", 40);
		Prodavnica Toscana = new Picerija("Toscana", 95);	
		
		CariGrad.spisakKlijenata.dodajKlijenta("Djura Djuric");
		Toscana.spisakKlijenata.dodajKlijenta("Pera Peric");
		
		System.out.println(CariGrad.getSpisakKlijenata().nadjiKlijenta("Djura Djuricic"));
		System.out.println(Toscana.getSpisakKlijenata().nadjiKlijenta("Pera Pericic"));

		CariGrad.kupiInventar("Krempita");
		Toscana.kupiInventar("Pasta alla Genovese");		
	}
}
