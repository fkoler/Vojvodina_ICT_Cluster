package Oblik;

public class Main {

	public static void main(String[] args) {
		
		Kvadrat nekiKvadrat = new Kvadrat("Purple", "Kvadrat", 10);
		Krug nekiKrug = new Krug("Crimson", "Krug", 10);
		
		nekiKvadrat.obimKvadrata();
		nekiKrug.obimKruga();		
		nekiKvadrat.povrsinaKvadrata();
		nekiKrug.povrsinaKruga();
		
		nekiKvadrat.showOblik();
		nekiKrug.showOblik();
	}
}
