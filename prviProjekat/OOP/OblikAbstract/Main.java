package OblikAbstract;

public class Main {

	public static void main(String[] args) {
		
		Kvadrat nekiKvadrat = new Kvadrat("Purple", "Kvadrat", 12);
		Krug nekiKrug = new Krug("Crimson", "Krug", 12);
		
		nekiKvadrat.racunajObim();
		nekiKrug.racunajObim();
		
		nekiKvadrat.racunajPovrsinu();
		nekiKrug.racunajPovrsinu();
		
		nekiKvadrat.showOblik();
		nekiKrug.showOblik();		
	}
}
