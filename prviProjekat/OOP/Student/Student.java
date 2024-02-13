package Student;

public class Student {

	String ime; // ime studenta
	String prezime; // prezime studenta
	double test1, test2, prosek;

	void postaviIme(String i) {
		ime = i;		
	}
	
	void postaviPrezime(String p) {
		prezime = p;		
	}

	void postaviPoene(double t1, double t2) {
		test1 = t1;
		test2 = t2;
	}

	void racunajProsek() {
		prosek = (test1 + test2) / 2;
	}

	void stampajPoene() {
		System.out.println("Student: " + ime + " " + prezime +
				" - prosecan broj poena: " + prosek);
	}
}
