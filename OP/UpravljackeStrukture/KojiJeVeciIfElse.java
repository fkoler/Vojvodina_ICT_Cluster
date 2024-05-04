package UpravljackeStrukture;

import prviProjekat.TextIO;

public class KojiJeVeciIfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Please input two numbers");

		int firstNumber = TextIO.getlnInt();
		int secondNumber = TextIO.getlnInt();

		if (firstNumber > secondNumber) {
			System.out.printf("\n%d is bigger than %d", firstNumber, secondNumber);
		} else if (firstNumber == secondNumber) {
			System.out.printf("\n%d is equal to %d", firstNumber, secondNumber);
		} else {
			System.out.printf("\n%d is bigger than %d", secondNumber, firstNumber);
		}
	}
}
