package StudentPrivate;

public class Student {
	
	String ime; 		//ime studenta
	String prezime;    	//prezime studenta 
	double test1, test2, prosek; 	//ocene na testovima

	Student(String i, String p, double t1, double t2){
		ime = i;
		prezime = p;
		test1 = t1;
		test2 = t2;
		prosek = 0; 
	}
	
	Student(String i, String p){
		ime = i;
		prezime = p;
	}
	
	void prosecnoPoena() { // prosek poena 					
		 prosek = (getTest1() + getTest2()) / 2.0;
	}

	void stampajPoene(){
		System.out.println("Student " + getIme() +" "+ getPrezime() + 
				" - prosecan broj poena: " + getProsek());
	}
	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public double getTest1() {
		return test1;
	}

	public double getTest2() {
		return test2;
	}

	public double getProsek() {
		return prosek;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setTest1(double test1) {
		this.test1 = test1;
	}

	public void setTest2(double test2) {
		this.test2 = test2;
	}

	public void setProsek(double prosek) {
		this.prosek = prosek;
	}

}
