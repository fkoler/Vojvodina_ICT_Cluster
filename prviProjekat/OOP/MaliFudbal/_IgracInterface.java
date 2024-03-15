package MaliFudbal;

public interface _IgracInterface {

	void dodajIgraca(KlasaIgrac igrac);

	void obrisiIgraca(KlasaIgrac igrac);

	KlasaIgrac pronadjiIgracaPoJmbg(String jmbg);
	
	KlasaIgrac pronadjiIgracaPoImenu(String ime);
}
