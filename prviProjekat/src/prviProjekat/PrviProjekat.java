package prviProjekat;

public class PrviProjekat {

	public static void main(String[] args) {		
		
//		example 1
		
		byte a;
		byte b;
		byte c;
		
		a = 0;
		b = -17;
		
		System.out.println("-----------Task 1-----------");
		System.out.println("	The value of a is: " + a);
		System.out.println("	The value of b is: " + b);
		
		c = b;
		b = a;
		a = c;
		
		System.out.println("After the replacement of values:");
		System.out.println("	The value of a is: " + a);
		System.out.println("	The value of b is: " + b);		
		
//		example 2
		
		char x = 'x';
		char y = 'y';
		char z = 'z';
		char container;		
		
		System.out.println("-----------Task 2-----------");
		System.out.println("	In the first place is:  " + x);
		System.out.println("	In the second place is: " + y);
		System.out.println("	In the third place is   " + z);
		
		container = x;
		x = y;
		y = z;
		z = container;
		
		System.out.println("After shifting to the left, the arrangement is as follows:");
		System.out.println("	In the first place is:  " + x);
		System.out.println("	In the second place is: " + y);
		System.out.println("	In the third place is   " + z);
	}
}
