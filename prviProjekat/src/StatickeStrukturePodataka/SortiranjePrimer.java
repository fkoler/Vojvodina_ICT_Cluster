package StatickeStrukturePodataka;

public class SortiranjePrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tmp;
		int[] x = new int[] { 5, 2, 9, 7, 1, 3 };

		System.out.print("x=[");
		System.out.print(x[0]);
		for (int i = 1; i < x.length; i++) {
			System.out.print(", " + x[i]);
		}
		System.out.println("]");

//		// bubble sortiranje
//		for (int i = 0; i < x.length; i++)
//			for (int j = i + 1; j < x.length; j++)
//				if (x[i] > x[j]) {
//					tmp = x[i];
//					x[i] = x[j];
//					x[j] = tmp;
//				}

//		insertion sortiranje
		int key, j;

		for (int i = 1; i < x.length; i++) {
			key = x[i];
			j = i - 1;
			while (j >= 0 && x[j] > key) {
				x[j + 1] = x[j];
				j = j - 1;
			}
			x[j + 1] = key;
		}

		System.out.println("Niz x nakon sortiranja");
		System.out.print("x=[");
		System.out.print(x[0]);
		for (int i = 1; i < x.length; i++) {
			System.out.print(", " + x[i]);
		}
		System.out.println("]");

	}
}
