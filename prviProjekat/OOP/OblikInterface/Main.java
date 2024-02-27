package OblikInterface;

public class Main {

	public static void main(String[] args) {
		
		Figura nekiKvadrat, nekiKrug;		

		nekiKvadrat = new Kvadrat("Purple", "Kvadrat", 12);
		nekiKrug = new Krug("Crimson", "Krug", 12);
		
		nekiKvadrat.racunajObim();
		nekiKrug.racunajObim();
		
		nekiKvadrat.racunajPovrsinu();
		nekiKrug.racunajPovrsinu();
		
		nekiKvadrat.showOblik();
		nekiKrug.showOblik();		
	}
}
