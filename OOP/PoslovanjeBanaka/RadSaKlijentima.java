package PoslovanjeBanaka;

public interface RadSaKlijentima {
	void dodajKlijenta(Klijent k);
	void obrisiKlijenta(Klijent k);
	int pronadjiKlijenta(String jmbg);
}
