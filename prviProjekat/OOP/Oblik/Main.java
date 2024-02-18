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
		
		nekiKvadrat.promeniBoju("Violet");
		nekiKrug.promeniBoju("DarkRed");
		
		System.out.println("\n\tPozvana metoda promeniBoju()\n");
		
		nekiKvadrat.showOblik();
		nekiKrug.showOblik();
	}
}
