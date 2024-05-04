package Programer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public ArrayList<Programer> readList() {
		
		Scanner s = null;
		ArrayList<Programer> list = new ArrayList<Programer>();

		try {
			s = new Scanner(new File("OOP\\Programer\\ListaProgramera.txt"));
			do {
				String ime = s.next();
				String prezime = s.next();
				int godine = Integer.parseInt(s.next());
				String senior = s.next();
				double plata = Double.parseDouble(s.next());
				Programer noviProgramer = new Programer(ime, prezime, godine, senior, plata);
				list.add(noviProgramer);
			} while (s.hasNext());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (s != null) {
				s.close();
			}
		}
		return list;
	}
}
