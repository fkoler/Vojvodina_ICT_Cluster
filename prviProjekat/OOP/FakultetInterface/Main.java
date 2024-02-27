package FakultetInterface;

public class Main {

public static void main(String[] args) {
	
		IPlata n, a, r;
		
		n = new Nastavnik("Dusan", "Gajic", 41, 5.0, 6, "vanredni profesor");
		a = new Asistent("Petar", "Petrovic", 28, 3.5, 3, "Čuveni Akademik");
		r = new NenastavniRadnik("Marko", "Markovic", 55, 2.5, "Čuvar", 35);		
		
		n.predstaviSe();
		a.predstaviSe();
		r.predstaviSe();
		
		n.racunajPlatu();
		a.racunajPlatu();
		r.racunajPlatu();
		
		System.out.println();
		
		n.stampajPlatu();
		a.stampajPlatu();
		r.stampajPlatu();
	}
}
