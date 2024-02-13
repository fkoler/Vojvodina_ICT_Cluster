package Student;

public class Main {

	public static void main(String[] args) {

		Student prviStudent = new Student();
		Student drugiStudent = new Student();

		prviStudent.postaviIme("Novak");
		prviStudent.postaviPrezime("Djokovic");
		drugiStudent.postaviIme("Ana");
		drugiStudent.postaviPrezime("Ivanovic");		

		prviStudent.postaviPoene(39.5, 53.8);
		drugiStudent.postaviPoene(38.7, 57.5);

		prviStudent.racunajProsek();
		drugiStudent.racunajProsek();

		prviStudent.stampajPoene();
		drugiStudent.stampajPoene();
	}
}
