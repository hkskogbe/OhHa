package Sovelluslogiikka.Tavarat;

import java.util.ArrayList;

/**
 * Tavarat-luokka pitää kirjaa pelissä tällä hetkellä käytössäolevista
 * tavaroista.
 *
 */
public class Tavarat {

    private ArrayList<String> esineet;

    /**
     * Luo tyhjän listan tavaroista
     */
    public Tavarat() {
        this.esineet = new ArrayList<String>();
    }

    /**
     * Lisää listaan uuden tavaran
     *
     * @param lisättävän tavaran nimi
     */
    public void lisaaTavara(String nimi) {
        this.esineet.add(nimi);
    }

    /**
     *
     * @return Palauttaa listan tavaroista
     */
    public ArrayList<String> getTavarat() {
        return this.esineet;
    }

    /**
     * Poistaa tavaran listasta
     *
     * @param poistettava tavara
     */
    public void poista(String item) {
        this.esineet.remove(item);
    }
}
