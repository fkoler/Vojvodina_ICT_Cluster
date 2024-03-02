package ElektronskoPoslovanje;

public class Main {

	public static void main(String[] args) {

		Poslasticarnica CariGrad = new Poslasticarnica("Pera", 40, "CariGrad");
		Picerija Toscana = new Picerija("Paja", 50, "Toscana");			

		CariGrad.kupiInventar("Krempita");
		Toscana.kupiInventar("Pasta alla Genovese");		
	}
}
