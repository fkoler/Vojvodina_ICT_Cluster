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
		this.getUtakmice().add(klasaUtakmica);
		System.out.printf(
				"Utakmica: %s vs %s resena je rezultatom %s. Utakmica dodata u listu. \n",
				klasaUtakmica.getPrviTim(),
				klasaUtakmica.getDrugiTim(),
				klasaUtakmica.getRezultat()
		);
	}

	// Metoda za brisanje utakmice
    public void obrisiUtakmicu(KlasaUtakmica klasaUtakmica) {
        String prviTim = klasaUtakmica.getPrviTim();
        String drugiTim = klasaUtakmica.getDrugiTim();
        if (pronadjiUtakmicu(prviTim, drugiTim) == null) {
        	System.out.println(
        			"\nUtakmica: " + prviTim + " vs " + drugiTim +
        			" nije pronađena u listi utakmica."
        	);
        	return;
        } else {
        	utakmice.remove(klasaUtakmica);
            System.out.println(
            		"\nUtakmica: " + prviTim + " vs " + 
            		drugiTim + " je uspešno obrisana.\n"
            );
        }
    }

	// Metoda za pretragu utakmice po imenima oba tima
	public KlasaUtakmica pronadjiUtakmicu(String prviTim, String drugiTim) {
		for (KlasaUtakmica klasaUtakmica : utakmice) {
			if (klasaUtakmica.getPrviTim().equals(prviTim) &&
				klasaUtakmica.getDrugiTim().equals(drugiTim)) {
				System.out.println(
						"\nUtakmica: " + prviTim + " vs " + drugiTim +
						" je pronađena u listi utakmica."
				);
				return klasaUtakmica;
			}
		}
		System.out.println(
				"\nUtakmica: " + prviTim + " vs " + drugiTim +
				" nije pronađena u listi utakmica."
		);
		return null;
	}
}
