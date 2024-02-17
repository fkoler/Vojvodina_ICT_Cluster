package Osoba;

public class Student extends Osoba {

	private int brojIndeksa;
	private double test1, test2; // broj poena na testovima

	Student(String ime, String prezime, int starost, int brojIndeksa, double test1, double test2) {
		super(ime, prezime, starost);
		this.brojIndeksa = brojIndeksa;
		this.test1 = test1;
		this.test2 = test2;
	}

	public double getTest1() {
		return test1;
	}

	public void setTest1(double test1) {
		this.test1 = test1;
	}

	public double getTest2() {
		return test2;
	}

	public void setTest2(double test2) {
		this.test2 = test2;
	}

	public int getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(int brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public double racunajPoene() { // metoda za prosek poena
		double prosek = (getTest1() + getTest2()) / 2;
		return prosek;
	}

	public void stampajPoene() { // metoda za stampu
		System.out.println("Student " + getIme() + " " + getPrezime() + ", broj indeksa: " + getBrojIndeksa()+", prosecan broj poena: " + racunajPoene());
	}
}
