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

    /**
     * Asettaa ruuduksi parametrina annettavan ruudun
     *
     * @param ruutu
     */
    public void setRuutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }

    /**
     * Asettaa sijainniksi parametrina annettavan sijainnin
     *
     * @param sijainti
     */
    public void setSijainti(Sijainti sijainti) {
        this.sijainti = sijainti;
    }

    /**
     * Asetaa suunnaksi parametrina annettavan suunnan
     *
     * @param suunta
     */
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

    /**
     * Palauttaa pelihahmon tämänhetkiset tavarat
     *
     * @return tavarat
     */
    public Tavarat getTavarat() {
        return tavarat;
    }

    /**
     * Asettaa pelihahmolle parametrina annetut tavarat.
     *
     * @param tavarat
     */
    public void setTavarat(Tavarat tavarat) {
        this.tavarat = tavarat;
    }
}
