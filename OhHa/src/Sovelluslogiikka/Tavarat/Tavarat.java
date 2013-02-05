package Sovelluslogiikka.Tavarat;

import java.util.ArrayList;

/**
 * Tavarat-luokka pitää kirjaa pelissä tällä hetkellä käytössäolevista
 * tavaroista.
 *
 */
public class Tavarat {

    private ArrayList<String> esineet;

    public Tavarat() {
        this.esineet = new ArrayList<String>();
    }

    public void lisaaTavara(String nimi) {
        this.esineet.add(nimi);
    }

    public ArrayList<String> getTavarat() {
        return this.esineet;
    }

    public void poista(String item) {
        this.esineet.remove(item);
    }
}
