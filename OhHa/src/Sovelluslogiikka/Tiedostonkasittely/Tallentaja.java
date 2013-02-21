package Sovelluslogiikka.Tiedostonkasittely;

import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tavarat.Tavarat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Calendar;

/**
 * Tallentaja-luokka käsittelee tallennusten kirjoittamista tiedostoon
 *
 */
public class Tallentaja {

    private String save;
    private FileWriter kirjoittaja;

    /**
     * Luo uuden Tallentajan, jolle annetaan tallennustiedoston nimi
     *
     * @param Tallennustiedoston nimi
     */
    public Tallentaja(String save) {
        this.save = save;
    }

    /**
     * Tallentaa parametreina annetut tiedot tiedostoon. Tallennuksen
     * ensimmäiselle riville tulee Suunta. Tämän alle liitetään merkintä
     * tallennusajankohdasta. Tallennus-tiedoston arvot talletetaan muodossa
     * nimi:arvo. Tavarat talletetaan muodossa -tavarannimi.
     *
     * @param tallennus
     * @param suunta
     * @param sijainti
     * @param tavarat
     * @throws IOException, jos tiedostopolku on virheellinen
     */
    public void tallenna(Tallennus tallennus, Suunta suunta, String sijainti, Tavarat tavarat) throws IOException, URISyntaxException {
        
        URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
        String kansio = new File(url.toURI()).getParent();
            
        this.kirjoittaja = new FileWriter(kansio + this.save);
        kirjoittaja.write(suunta.toString() + "\n");

        kirjoittaja.write(Calendar.getInstance().getTime().toString() + "\n");

        kirjoittaja.write(sijainti + "\n");

        for (String t : tallennus.getArvoLista().keySet()) {
            kirjoittaja.write(t + ":" + tallennus.getArvoLista().get(t) + "\n");
        }

        for (String e : tavarat.getTavarat()) {
            kirjoittaja.write("-" + e + "\n");
        }

        kirjoittaja.close();
    }

    /**
     * Tarkistaa, että parametrina annettu sana sisältää vain pieniä kirjaimia,
     * isoja kirjaimia sekä numeroita.
     *
     * @param sana
     * @return boolean, onko kirjoitusmuoto oikein
     */
    boolean kirjoitusMuotoOnOikein(String sana) {

        if (sana.matches("[0-9a-zA-Z]+")) {
            return true;
        }

        return false;
    }
}
