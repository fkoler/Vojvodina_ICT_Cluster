package KopiranjeBajtova;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class KopiranjeBajtova {

	public static void main(String[] args) throws IOException {
		FileInputStream ulaz = null;
		FileOutputStream izlaz = null;
		try {
			ulaz = new FileInputStream("OOP\\KopiranjeBajtova\\ulazBajt.txt");
			izlaz = new FileOutputStream("OOP\\KopiranjeBajtova\\izlazBajt.txt");
			int c;
			while ((c = ulaz.read()) != -1) {
				izlaz.write(c);
				System.out.println(c);
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
