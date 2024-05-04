package Racunar;

/* • Kreirati klasu Racunar sa atributima procesor (tipa
String), radniTakt (tipa double), kapacitetMemorije
(tipa int), kao i metodama za postavljanje naziva i radnog
takta procesora, postavljanje kapaciteta memorije u GB,
računanje indeksa performansi računara po formuli:
indeksPerformansi = 10*radniTakt + kapacitetMemorije
i štampanje indeksa performansi računara.

• Potom testirati klasu kreiranjem pet objekta u okviru glavnog
programa, kojima prvo postavljamo vrednosti atributa, a
potom računamo i prikazujemo njihovu rang listu uređenu
po indeksu performansi u opadajućem redosledu. */

public class Racunar {

	String oznakaProcesora;
	double radniTakt, indexPerformansi;
	int kapacitetMemorije;

	Racunar(String procesor, double takt, int memorija) {
		oznakaProcesora = procesor;
		radniTakt = takt;
		kapacitetMemorije = memorija;
	}

	public void postaviOznakuProcesora(String procesor) {
		oznakaProcesora = procesor;
	}	

	public void postaviRadniTakt(double takt) {
		radniTakt = takt;
	}	

	public void postaviKapacitetMemorije(int memorija) {
		kapacitetMemorije = memorija;
	}

	double izracunajIndexPerformansi() {
		indexPerformansi = 10 * radniTakt + kapacitetMemorije;
		return indexPerformansi;
	}
	
	public double postaviIndexPerformansi() {
		return indexPerformansi;
	}	

	void stampanjePodataka() {
		System.out.println("Procesor: " + oznakaProcesora + ", " + radniTakt + " GHz, RAM: "
				+ kapacitetMemorije + " GB.");
		System.out.println("\tPerformanse:\t< " + indexPerformansi + " >\n");
	}
}
