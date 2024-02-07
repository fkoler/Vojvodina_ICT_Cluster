package Potprogrami;

public class KalkulatorPrimer {

	public static void main(String[] args) {

		double operand1 = 0, operand2 = 0;
		double zbir = 0, razlika = 0, proizvod = 0, kolicnik = 0;

		System.out.println("--Program za simuliranje kalkulatora--");

		System.out.println("--Izaberite zeljenu operaciju--");
		System.out.println("--1. Sabiranje--");
		System.out.println("--2. Oduzimanje--");
		System.out.println("--3. Mnozenje--");
		System.out.println("--4. Deljenje--");

		int biranjeOperacije = 0;

		biranjeOperacije = TextIO.getlnInt();

		operand1 = unosOperanda("Unesite prvi operand:");
		operand2 = unosOperanda("Unesite drugi operand:");
		System.out.println("--------------------------------------");

		if (biranjeOperacije == 1) {
			zbir = sabiranje(operand1, operand2);
			prikaziRezultat(operand1, operand2, zbir, '+');
		}

		if (biranjeOperacije == 2) {
			razlika = oduzimanje(operand1, operand2);
			prikaziRezultat(operand1, operand2, razlika, '-');
		}

		if (biranjeOperacije == 3) {
			proizvod = mnozenje(operand1, operand2);
			prikaziRezultat(operand1, operand2, proizvod, '*');
		}

		if (biranjeOperacije == 4) {
			kolicnik = deljenje(operand1, operand2);
			prikaziRezultat(operand1, operand2, kolicnik, '/');
		}
	}

	static double unosOperanda(String poruka) {
		double operand = 0.0;
		System.out.println(poruka);
		operand = TextIO.getlnDouble();
		return operand;
	}

	static double sabiranje(double op1, double op2) {
		return op1 + op2;
	}

	static double oduzimanje(double op1, double op2) {
		return op1 - op2;
	}

	static double mnozenje(double op1, double op2) {
		return op1 * op2;
	}

	static double deljenje(double op1, double op2) {
		return op1 / op2;
	}

	static void prikaziRezultat(double op1, double op2, double rez, char op) {
		System.out.printf("%2.2f %s %2.2f = %2.2f", op1, op, op2, rez);
	}
}