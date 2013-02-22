package Sovelluslogiikka;

import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Tavarat.Tavarat;

/**
 * Tiedot pitää kirjaa pelin tämänhetkisestä tilasta
 *
 */
public class Tiedot {

    private String tallennusKansio;
    private Ruutu ruutu;
    private Suunta suunta;
    private Sijainti sijainti;
    private Tavarat tavarat;

    public Tiedot() {
        this.tallennusKansio = "/Tallennukset/";
    }
    /**
     * Palauttaa kansion, jossa tallennukset sijaitsevat.
     *
     * @return
     */
    public String getTallennuskansio() {
        return this.tallennusKansio;
    }

    public void setRuutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }

    public void setSijainti(Sijainti sijainti) {
        this.sijainti = sijainti;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }
  /**
     *
     * @return Palauttaa tämänhetkisen ruudun
     */
    public Ruutu getRuutu() {
        return ruutu;
    }
/**
     *
     * @return Palauttaa nykyisen sijainnin
     */
    public Sijainti getSijainti() {
        return sijainti;
    }
   /**
     *
     * @return Palauttaa tämänhetkisen suunnan
     */
    public Suunta getSuunta() {
        return suunta;
    }

    public Tavarat getTavarat() {
        return tavarat;
    }

    public void setTavarat(Tavarat tavarat) {
        this.tavarat = tavarat;
    }
    
    
}
