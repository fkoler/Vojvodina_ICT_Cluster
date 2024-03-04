package TokKaraktera;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TokKaraktera {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader ulaz = null;
		FileWriter izlaz = null;

		try {
			ulaz = new FileReader("OOP\\TokKaraktera\\ulazKarakter.txt");
			izlaz = new FileWriter("OOP\\TokKaraktera\\izlazKarakter.txt");
			int c;
			while ((c = ulaz.read()) != -1) {
				izlaz.write(c);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (ulaz != null) {
				ulaz.close();
			}
			if (izlaz != null) {
				izlaz.close();
			}
		}		
	}
}
