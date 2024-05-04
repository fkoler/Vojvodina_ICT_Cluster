package UpravljackeStrukture;

public class ForDinuPrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i, N = 4, x = 0;

		for (i = 0; i < N; i++) {

			if ((i % 2) != 0)
//				break; // x = 1
//				continue; // x = 2
			x++;
		}

		System.out.println("x = " + x);
	}
}
