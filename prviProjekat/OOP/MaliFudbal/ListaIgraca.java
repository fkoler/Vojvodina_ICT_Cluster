package MaliFudbal;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class ListaIgraca implements _IgracInterface {

	private ArrayList<KlasaIgrac> igraci;

	// Konstruktor
	public ListaIgraca() {
		this.setIgraci(new ArrayList<>());
	}

	// Getter za listu igrača
	public ArrayList<KlasaIgrac> getIgraci() {
		return igraci;
	}

	public void setIgraci(ArrayList<KlasaIgrac> igraci) {
		this.igraci = igraci;
	}

	// Metoda za dodavanje igrača
	public void dodajIgraca(KlasaIgrac klasaIgrac) {
		this.getIgraci().add(klasaIgrac);
		System.out.printf(
				"\nNovi Igrac dodat: %s, %s, %s, %s \n", 
				klasaIgrac.getIme(), klasaIgrac.getPrezime(),
				klasaIgrac.getJmbg(), klasaIgrac.getImeTima()
			);
	}

	// Metoda za brisanje igrača
	public void obrisiIgraca(KlasaIgrac klasaIgrac) {
		String jmbg = klasaIgrac.getJmbg();

		if (pronadjiIgraca(jmbg) == null) {
			System.out.printf("Greska, igrac sa jmbg: %s nije pronadjen na listi \n", jmbg);
		} else {
			this.getIgraci().remove(klasaIgrac);
			System.out.printf("Igrac sa jmbg: %s je obrisan sa liste \n", jmbg);
		}
	}

	// Metoda za pretragu igrača po jmbg
	public KlasaIgrac pronadjiIgraca(String jmbg) {
	    ArrayList<KlasaIgrac> igraci = this.getIgraci();
	    for (KlasaIgrac igrac : igraci) {
	        System.out.println("Proveravam igrača: " + igrac);
	        if (igrac.getJmbg().equals(jmbg)) {
	            System.out.println("Igrač sa JMBG-om " + jmbg + " je pronađen: " + igrac);
	            return igrac;
	        }
	    }
	    System.out.println("Igrač sa JMBG-om " + jmbg + " nije pronađen.");
	    return null;
	}

	// Metoda za učitavanje podataka o igračima iz datoteke
	public void ucitajPodatkeOIgracima(KlasaTurnir klasaTurnir, String imeDatoteke) {
	    try (BufferedReader br = new BufferedReader(new FileReader(imeDatoteke))) {
	        for (String line = br.readLine(); line != null; line = br.readLine()) {
	            // Format linije: Ime Prezime JMBG ImeTima
	            String[] parts = line.split(" ");
	            if (parts.length == 4) {
	                String ime = parts[0];
	                String prezime = parts[1];
	                String jmbg = parts[2];
	                String imeTima = parts[3];
	                KlasaIgrac klasaIgrac = new KlasaIgrac(ime, prezime, jmbg, imeTima);
	                igraci.add(klasaIgrac);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
