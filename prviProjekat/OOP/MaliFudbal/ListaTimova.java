package MaliFudbal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaTimova implements _TimInterface{

    private ArrayList<KlasaTim> timovi;  

    // Konstruktor
    public ListaTimova() {
        this.setTimovi(new ArrayList<>());
    }    

	// Getter za listu timova
    public ArrayList<KlasaTim> getTimovi() {
        return timovi;
    }

    public void setTimovi(ArrayList<KlasaTim> timovi) {
		this.timovi = timovi;
	}

    // Metoda za dodavanje tima
    public void dodajTim(KlasaTim tim) {
        this.getTimovi().add(tim);
        System.out.printf(
        		"Tim %s, iz %s, broj igraca %d, je dodat u listu \n",
        		tim.getIme(), tim.getGrad(), tim.getBrojIgraca()
        	);
    }

 // Metoda za brisanje tima
    public void obrisiTim(KlasaTim tim) {
        String imeTima = tim.getIme();
        
        if(pronadjiTim(imeTima) == null) {
        	System.out.printf("Greska, tim: %s nije pronadjen na listi \n", imeTima);
        } else {
        	this.getTimovi().remove(tim);
        	System.out.printf("Tim: %s je obrisan sa liste \n", imeTima);
        }
    }

    // Metoda za pretragu tima po imenu
    public KlasaTim pronadjiTim(String ime) {
       ArrayList<KlasaTim> timovi = this.getTimovi();
       for(KlasaTim tim: timovi) {
    	   System.out.println("Proveravam tim: " + tim);
    	   if(tim.getIme().equals(ime)) {
    		   System.out.println("Tim: " + ime + " je pronadjen.");
    		   return tim;
    	   }
       }
       System.out.println("Tim: " + ime + "nije pronadjen.");
       return null;
    }
    
 // Metoda za učitavanje podataka o timovima iz datoteke
    public void ucitajPodatkeOTimovima(KlasaTurnir klasaTurnir, String imeDatoteke) {
        try (BufferedReader br = new BufferedReader(new FileReader(imeDatoteke))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Format linije: ImeTima Grad BrojIgraca
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    String imeTima = parts[0];
                    String grad = parts[1];
                    int brojIgraca = Integer.parseInt(parts[2]);
                    KlasaTim klasaTim = new KlasaTim(imeTima, grad, brojIgraca);
                    timovi.add(klasaTim);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
