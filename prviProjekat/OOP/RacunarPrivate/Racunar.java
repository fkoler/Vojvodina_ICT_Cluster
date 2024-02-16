package RacunarPrivate;

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

	private String oznakaProcesora;
	private double radniTakt, indexPerformansi;
	private int kapacitetMemorije;

	public Racunar() {}

	Racunar(String oznakaProcesora, double radniTakt, int kapacitetMemorije) {
		this.oznakaProcesora = oznakaProcesora;
		this.radniTakt = radniTakt;
		this.kapacitetMemorije = kapacitetMemorije;
	}

	public double izracunajIndexPerformansi() {
		indexPerformansi = 10 * radniTakt + kapacitetMemorije;
		return indexPerformansi;
	}

	public double setIndexPerformansi() {
		return this.indexPerformansi;
	}

	void stampanjePodataka() {
		System.out.println(
				"Procesor: " + oznakaProcesora + ", " + radniTakt + " GHz, RAM: " + kapacitetMemorije + " GB.");
		System.out.println("\tPerformanse:\t< " + indexPerformansi + " >\n");
	}
}
