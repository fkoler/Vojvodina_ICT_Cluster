package MaliFudbal;

public interface _UtakmicaInterface {
	
	void dodajUtakmicu(KlasaUtakmica utakmica);

	void obrisiUtakmicu(KlasaUtakmica utakmica);

	KlasaUtakmica pronadjiUtakmicu(String prviTim, String drugiTim);
}
