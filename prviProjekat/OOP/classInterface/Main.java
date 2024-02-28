package classInterface;

public class Main {
	
    public static void main(String[] args) {
    	
        Bazna objekat1 = new Izvedena();
        Izvedena objekat2 = new Izvedena();        
        Klasa objekat3 = new Klasa();
        Bazna objekat4 = new Izvedena();
        Interfejs objekat5 = new Klasa();
        
        objekat1.prikazi();
        objekat2.funkcija();        
        objekat3.prikazi();
        objekat4.prikazi();
        objekat5.prikazi();
        System.out.println(Interfejs.atribut);
    }
}
