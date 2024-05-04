package StudentPrivate;

public class Main {

	public static void main(String[] args) {

		Student prviStudent = new Student("Novak", "Djokovic", 39.5, 53.8);
		Student drugiStudent = new Student("Ana", "Ivanovic",38.7, 57.5);		

		prviStudent.prosecnoPoena();
		drugiStudent.prosecnoPoena();

		prviStudent.stampajPoene();
		drugiStudent.stampajPoene();
	}
}
