package RacunarPrivate;

public class Main {

	static final int BROJ_RACUNARA = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Racunar[] pc = new Racunar[BROJ_RACUNARA];

		// pet racunara
		pc[0] = new Racunar("AMD Ryzen 7", 3.2, 32);
		pc[1] = new Racunar("Intel Core i3", 2.2, 16);
		pc[2] = new Racunar("Intel Core i9", 4.2, 128);
		pc[3] = new Racunar("AMD Ryzen 9", 4.0, 64);
		pc[4] = new Racunar("Intel Caleron N4020", 2.8, 8);

		pc[0].izracunajIndexPerformansi();
		pc[1].izracunajIndexPerformansi();
		pc[2].izracunajIndexPerformansi();
		pc[3].izracunajIndexPerformansi();
		pc[4].izracunajIndexPerformansi();

		// rang lista
		for (int i = 0; i < pc.length - 1; i++) {
			for (int j = i + 1; j < pc.length; j++) {
				if (pc[j].setIndexPerformansi() > pc[i].setIndexPerformansi()) {
					Racunar nekiPC = pc[i];
					pc[i] = pc[j];
					pc[j] = nekiPC;
				}
			}
		}

		for (int i = 0; i < pc.length; i++) {
			pc[i].stampanjePodataka();
		}
	}
}
