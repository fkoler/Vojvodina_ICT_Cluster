package Osoba;

public class MainStudent {

	public static void main(String[] args) {

		Student s1 = new Student("Student1", "Prezime1", 25, 980765, 78.90, 67.80);
		Student s2 = new Student("Student2", "Prezime2", 21, 345612, 67.40, 98.60);

		s1.predstaviSe();
		s2.predstaviSe();
		
		System.out.println();

		s1.racunajPoene();
		s2.racunajPoene();		

		s1.stampajPoene();
		s2.stampajPoene();
	}
}
