package StatickeStrukturePodataka;

import java.util.Arrays;

public class SortiranjeStringova {

	public static void main(String[] args) {

		String tmp;
		String[] x = new String[] { "Dinu", "Nikola", "Ana", "Nole", "Pera", "Babelo", "Nikol" };

		System.out.print("x=[");
		System.out.print(x[0]);
		for (int i = 1; i < x.length; i++) {
			System.out.print(", " + x[i]);
		}
		System.out.println("]");

//		for (int i = 0; i < x.length; i++)
//			for (int j = i + 1; j < x.length; j++)
//				if (x[i].compareTo(x[j]) > 0) {
//					tmp = x[i];
//					x[i] = x[j];
//					x[j] = tmp;
//				}

//		ili ugradjena klasa
		Arrays.sort(x);
		
		System.out.println("Niz x nakon sortiranja");
		System.out.print("x=[");
		System.out.print(x[0]);
		for (int i = 1; i < x.length; i++) {
			System.out.print(", " + x[i]);
		}
		System.out.println("]");
	}
}
