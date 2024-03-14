package MaliFudbal;

import java.util.ArrayList;
import java.util.List;

public class ListaUtakmica implements _UtakmicaInterface {
	private List<KlasaUtakmica> utakmice;

	// Konstruktor
	public ListaUtakmica() {
		this.utakmice = new ArrayList<>(); // Inicijalizacija liste
	}

	// Getter za listu utakmica
	public List<KlasaUtakmica> getUtakmice() {
		return utakmice;
	}

	public void setUtakmice(List<KlasaUtakmica> utakmice) {
		this.utakmice = utakmice;
	}

	// Metoda za dodavanje utakmice
	public void dodajUtakmicu(KlasaUtakmica klasaUtakmica) {
		utakmice.add(klasaUtakmica);
	}

	// Metoda za brisanje utakmice
	public void obrisiUtakmicu(KlasaUtakmica klasaUtakmica) {
		utakmice.remove(klasaUtakmica);
	}

	// Metoda za pretragu utakmice po imenima oba tima
	public KlasaUtakmica pronadjiUtakmicu(String prviTim, String drugiTim) {
		for (KlasaUtakmica klasaUtakmica : utakmice) {
			if (klasaUtakmica.getPrviTim().equals(prviTim) && klasaUtakmica.getDrugiTim().equals(drugiTim)) {
				return klasaUtakmica;
			}
		}
		return null;
	}
}
