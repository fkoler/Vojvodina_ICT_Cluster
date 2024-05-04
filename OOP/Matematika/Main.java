package Matematika;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		IFunkcija linearna = new LinearnaFunkcija();

		BufferedReader LinearnaInput = null;
		BufferedWriter LinearnaOutput = null;

		try {
			LinearnaInput = new BufferedReader(
					new FileReader("OOP\\Matematika\\funkcija1.txt")
					);
			LinearnaOutput = new BufferedWriter(
					new FileWriter("OOP\\Matematika\\nule1.txt")
					);

			linearna.ucitajParametre(LinearnaInput);

			if (linearna.imaNulu()) {
				linearna.stampajPodatke(LinearnaOutput);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (LinearnaInput != null)
				LinearnaInput.close();
			if (LinearnaOutput != null)
				LinearnaOutput.close();
		}
	}
}
