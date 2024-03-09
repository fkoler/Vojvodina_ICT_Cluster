package Singleton;

public class Main {

	public static void main(String[] args) {
		
		Singleton s1 = Singleton.pribaviInstancu();
		Singleton s2 = Singleton.pribaviInstancu();
		Singleton s3 = Singleton.pribaviInstancu();
		
		s1.str = "Pozdrav iz Maina br 1";
		s2.str = "Pozdrav iz Maina br 2";
		s3.str = "Pozdrav iz Maina br 3";
		
		System.out.println(s1.str);
		System.out.println(s2.str);
		System.out.println(s3.str);
	} 
}
