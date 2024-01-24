package prviProjekat;

public class Operatiori {

	public static void main(String[] args) {

		int a = 4, b = 5;

		int u = a - -b;

		System.out.println("u = " + u); // 9

		a++;
		b--;

		System.out.println("a = " + a); // 5
		System.out.println("b = " + b); // 4

		int x = ++a; // a = a + 1; x = a

		System.out.println("x = " + x);

		int y = a++; // y = a; a = a + 1
		System.out.println("a = " + a);
		System.out.println("y = " + y);

		a = (x + y) + 1;

//		double z = (double) a / b; // kastovanje - eksplicitno konvertovanje
		double z = b / a;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("z = " + z);

		int r = (int) (0.4 + 4.);
		System.out.println("r = " + r);

		double t = 102.0 / z;
		System.out.println("t = " + (t - a));

		z = 1.2 + t;
		System.out.println("z = " + z);

		boolean ba = x < y;
		System.out.println("ba = " + ba);
		
		boolean bt = y != z;
		System.out.println("bt = " + bt);

//		boolean a = true, b = false;
//		/* Negacija. */
//		System.out.print("Negacija od true je: "); System.out.println(!a);
//		System.out.print("Negacija od false je: "); System.out.println(!b);
//		/* I operacija. */
//		System.out.print("true I false je: "); System.out.println(a && b);
//		System.out.print("true I true je: "); System.out.println(a && a);
//		System.out.print("false I false je: "); System.out.println(b && b);
//		/* ILI operacija. */
//		System.out.print("true ILI false je: "); System.out.println(a || b);
//		System.out.print("true ILI true je: "); System.out.println(a || a);
//		System.out.print("false ILI false je: "); System.out.println(b || b);
//		/* Eksluzivno ILI operacija. */
//		System.out.print("true EXILI false je: "); System.out.println(a ^ b);
//		System.out.print("true EXILI true je: "); System.out.println(a ^ a);
//		System.out.print("false EXILI false je: "); System.out.println(b ^ b);

//		int a = 6;
//		int b = 4;
//
//		int o = (a = b + 2) * 10;
//
//		System.out.println("a = " + a);
//		System.out.println("b = " + b);
//		System.out.println("o = " + o);

//		b = b + 10;
//		b += 10;
//
//		System.out.println("b = " + b);
//
//		o *= b + a; // o = o * b + a || o = o * (b + a) // prvo desna strana
//
//		System.out.println("o = " + o);
//
//		int x = (a < b) ? a : b;
//
//		System.out.println("Manji od a = " + a + " i b = " + b + " je " + x);

	}
}
