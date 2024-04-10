package Programer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int x = 8;
//		int y = 4;
//		int z = 1;
//		x /= y - z;
//
//		System.out.println(x);

		////////////////////////////////

//		int a = -1;
//		int b = -10;
//		int c;
//
//		int X = 8;
//		int Y = 4;
//
//		if (X > (Y - 1)) {
//			Y = X + 1;
//		} else if (X < 10 * Y) {
//			Y = X - 1;
//		}
//		System.out.println(Y);
		//////////////////////////////////////////

		int x = 2;
		int y = 2 * x + 2 * (x + 4);

		for (int k = x; k <= y; k++) {
			if (k % 2 != 1) {
				continue;
			}
			System.out.println("D");
		}

	}
}
