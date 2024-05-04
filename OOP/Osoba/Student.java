package Osoba;

public class Student extends Osoba {

	private int brojIndeksa;
	private double test1, test2; 	//ocene na testovima
	
	public Student(String ime, String prezime, int starost, int brojIndeksa, double test1, double test2){
		super(ime, prezime, starost);
		this.setBrojIndeksa(brojIndeksa);
		this.setTest1(test1);
		this.setTest2(test2);
	}
	
	protected void setBrojIndeksa(int brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	
	protected int getBrojIndeksa() {
		return this.brojIndeksa;
	}
    
	
	protected void setTest1(double test1) {
		this.test1 = test1;
	}
	
	protected double getTest1() {
		return this.test1;
	}
    
	protected void setTest2(double test2) {
		this.test2 = test2;
	}
	
	protected double getTest2() {
		return this.test2;
	}
	
	public double racunajPoene() { // metoda racuna prosek poena  
		double prosek = (this.getTest1() + this.getTest2()) / 2;
		return prosek;
	}

	public void stampajPoene(){  // metoda za stampu
		System.out.println("Student " + this.getIme() +" "+ this.getPrezime() + " " + this.getBrojIndeksa() + " - prosecan broj poena: " + this.racunajPoene());
	}	
}
