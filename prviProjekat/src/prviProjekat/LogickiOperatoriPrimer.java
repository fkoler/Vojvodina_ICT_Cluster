package prviProjekat;

public class LogickiOperatoriPrimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean a = true, b = false;
		
		/* Negacija. */
		System.out.println("--- Negacija ---");
		System.out.print("Negacija od true je: "); System.out.println(!a);
		System.out.print("Negacija od false je: "); System.out.println(!b);
		System.out.println("");
		
		/* I operacija. */
		System.out.println("--- I operacija '&&' ---");
		System.out.print("true I false je: "); System.out.println(a && b);
		System.out.print("false I true je: "); System.out.println(b && a);
		System.out.print("true I true je: "); System.out.println(a && a);
		System.out.print("false I false je: "); System.out.println(b && b);
		System.out.println("");
		
		/* ILI operacija. */
		System.out.println("--- ILI operacija '||' ---");
		System.out.print("true ILI false je: "); System.out.println(a || b);
		System.out.print("false ILI true je: "); System.out.println(b || a);
		System.out.print("true ILI true je: "); System.out.println(a || a);
		System.out.print("false ILI false je: "); System.out.println(b || b);
		System.out.println("");
		
		/* I operacija. */
		System.out.println("--- I operacija '&' ---");
		System.out.print("true I false je: "); System.out.println(a & b);
		System.out.print("false I true je: "); System.out.println(b & a);
		System.out.print("true I true je: "); System.out.println(a & a);
		System.out.print("false I false je: "); System.out.println(b & b);
		System.out.println("");
		
		/* ILI operacija. */
		System.out.println("--- ILI operacija '|' ---");
		System.out.print("true ILI false je: "); System.out.println(a | b);
		System.out.print("false ILI true je: "); System.out.println(b | a);
		System.out.print("true ILI true je: "); System.out.println(a | a);
		System.out.print("false ILI false je: "); System.out.println(b | b);
		System.out.println("");
		
		/* Eksluzivno ILI operacija. */
		System.out.println("--- EXILI operacija '^' ---");
		System.out.print("true EXILI false je: "); System.out.println(a ^ b);
		System.out.print("false EXILI true je: "); System.out.println(b ^ a);
		System.out.print("true EXILI true je: "); System.out.println(a ^ a);
		System.out.print("false EXILI false je: "); System.out.println(b ^ b);
	}
}
