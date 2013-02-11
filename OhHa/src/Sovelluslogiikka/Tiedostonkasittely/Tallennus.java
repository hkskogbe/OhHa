package Sovelluslogiikka.Tiedostonkasittely;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Tallennus sisältää tiedot pelin sisäisistä muuttujista.
 *
 */
public class Tallennus implements Serializable {

    private Map<String, Boolean> arvot;

    /**
     * Uusi HashMap-pohjainen tallennustiedosto
     */
    public Tallennus() {
        this.arvot = new HashMap<String, Boolean>();
    }

    /**
     * Uusi HashMap-pohjainen tallennustiedosto
     *
     * @param Tallennukset arvot HashMap<String,Boolean> -muodossa
     */
    public Tallennus(Map<String, Boolean> arvot) {
        this.arvot = arvot;
    }

    /**
     * Asettaa Stringin määrittelemän tallennusarvon arvoksi true
     *
     * @param arvo, joka halutaan asettaa trueksi
     */
    public void setTrue(String nimi) {
        this.arvot.put(nimi, true);
    }

    /**
     * Asettaa Stringin määrittelemän tallennusarvon arvoksi false
     *
     * @param arvo, joka halutaan asettaa falseksi
     */
    public void setFalse(String nimi) {
        this.arvot.put(nimi, false);
    }

    /**
     * Palauttaa booleanin haetusta tallennetusta arvosta
     *
     * @param haettu arvo
     * @return
     */
    public boolean getArvo(String haettu) {

        for (String nimi : arvot.keySet()) {
            if (nimi.equals(haettu)) {
                return arvot.get(nimi);
            }
        }
        return false;
    }

    /**
     * Palauttaa Tallennus-olion sisältämän HashMapin arvoista
     *
     * @return HashMap<String,Boolean> arvoista
     */
    public Map<String, Boolean> getArvoLista() {
        return this.arvot;
    }
}
