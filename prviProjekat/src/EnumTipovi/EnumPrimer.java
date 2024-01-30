package EnumTipovi;

public class EnumPrimer {
	enum OCENA {
		Jedan, Dva, Tri, Cetiri, Pet
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OCENA x = OCENA.Dva;

		System.out.println(x);
		System.out.println(x.ordinal());
	}
}
