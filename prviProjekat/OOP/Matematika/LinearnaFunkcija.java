package Matematika;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class LinearnaFunkcija implements IFunkcija {

	private double a, b;

	public void ucitajParametre(BufferedReader parametar) throws IOException {
		a = Double.parseDouble(parametar.readLine());
		b = Double.parseDouble(parametar.readLine());
	}

	public double vrednostTacke(double x) {
		return (a * x) + b;
	}

	public Boolean imaNulu() {
		if (a == 0 || b == 0) {
			return true;
		} else {
			return false;
		}
	}

	public double nadjiNulu() {
		return -b / a;
	}

	public void stampajPodatke(BufferedWriter podatak) {
		try {
			podatak.write(Double.valueOf(nadjiNulu()).toString());
			System.out.println("Nula pronadjena u fajlu.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
