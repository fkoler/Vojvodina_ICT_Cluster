package Oblik;

public class Main {

	public static void main(String[] args) {
		
		Kvadrat nekiKvadrat = new Kvadrat("Purple", "Kvadrat", 12);
		Krug nekiKrug = new Krug("Crimson", "Krug", 12);
		
		nekiKvadrat.obimKvadrata();
		nekiKrug.obimKruga();
		
		nekiKvadrat.povrsinaKvadrata();
		nekiKrug.povrsinaKruga();
		
		nekiKvadrat.showOblik();
		nekiKrug.showOblik();
		
		nekiKvadrat.promeniBoju("Violet");
		nekiKrug.promeniBoju("DarkRed");
		
		System.out.println("\n\tpromeniBoju()\n");
		
		nekiKvadrat.showOblik();
		nekiKrug.showOblik();
	}
}
