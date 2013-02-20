package Sovelluslogiikka.Tiedostonkasittely;

import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.A2.SijaintiA2;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tavarat.Tavarat;
import Sovelluslogiikka.Tiedot;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lataaja-luokka käsittelee tallennuksien lataamisen.
 *
 */
public class Lataaja {

    private Scanner scanner;
    private String save;

    /**
     * Uusi lataaja saa konstruktorin arvona kohdetiedoston
     *
     * @param kohdetiedosto
     */
    public Lataaja(String save) {
        this.save = save;
    }

    /**
     * Lukee tallennustiedostosta rivit, jotka kertovat kyseisen tallennuksen
     * Tallennus-olion sisällön.
     *
     * @return Ladattu tallennus
     * @throws FileNotFoundException, jos tiedostopolku on virheellinen
     */
    public Tallennus lataaTallennus() throws FileNotFoundException {

        File s = new File(save);
        luoSkanneri();


        Tallennus uusiTallennus = new Tallennus();

        while (scanner.hasNextLine()) {
            String nyt = scanner.nextLine();
            if (nyt.contains(":")) {
                String[] osat = nyt.split(":");
                if (osat[1].equals("true")) {
                    uusiTallennus.setTrue(osat[0]);
                } else {
                    uusiTallennus.setFalse(osat[0]);
                }
            }
        }
        return uusiTallennus;
    }

    /**
     * Lukee tallennustiedostosta rivin, joka kertoo tallennetun Suunnan.
     *
     * @return Suunta
     * @throws FileNotFoundException, jos tiedostopolku on virheellinen
     */
    public Suunta lataaSuunta() throws FileNotFoundException {
        luoSkanneri();

        String s = scanner.nextLine();

        if (s.equals("POHJOINEN")) {
            return Suunta.POHJOINEN;
        } else if (s.equals("ITA")) {
            return Suunta.ITA;
        } else if (s.equals("ETELA")) {
            return Suunta.ETELA;
        } else {
            return Suunta.LANSI;
        }
    }

    /**
     * Lukee tallennustiedostosta rivit, jotka kertovat tallennetun
     * Tavarat-olion sisällön
     *
     * @return Tavarat
     * @throws FileNotFoundException, jos tiedostopolku on virheellinen
     */
    public Tavarat lataaTavarat() throws FileNotFoundException {
        luoSkanneri();

        Tavarat tav = new Tavarat();

        while (scanner.hasNextLine()) {
            String nyt = scanner.nextLine();

            if (nyt.contains("-")) {
                nyt = nyt.substring(1);
                tav.lisaaTavara(nyt);
            }
        }
        return tav;
    }

    /**
     * Lukee tallennustiedostosta rivin, joka kertoo tallennetun sijainnin, ja
     * luo uuden sijainnin kyseisen tiedon pohjalta.
     *
     * @param tiedot
     * @return Palauttaa uuden sijainnin
     * @throws FileNotFoundException, jos tiedostopolku on virheellinen
     */
    public Sijainti lataaSijainti(Tiedot tiedot) throws FileNotFoundException {
        luoSkanneri();

        String sijaintiString = "";

        while (scanner.hasNextLine()) {
            String nyt = scanner.nextLine();

            if (nyt.contains("Sovelluslogiikka.Ruudut")) {
                sijaintiString = nyt;
                break;
            }
        }

        return this.etsiSijaintiStringinPerusteella(sijaintiString, tiedot);
    }

    /**
     * Luo uuden sijainnin String-muotoisen nimen pohjalta. Jokainen pelin
     * sijainti tulee listata tähän metodiin.
     *
     * @param Sijainti string-muotoisena
     * @param tiedot
     * @return Sijainti Sijainti-oliona
     */
    private Sijainti etsiSijaintiStringinPerusteella(String sijaintiString, Tiedot tiedot) {
        sijaintiString = sijaintiString.substring(24);
        String sijainti = "";

        for (int i = 0; i < sijaintiString.length(); i++) {
            char a = sijaintiString.charAt(i);
            if (a == '.') {
                break;
            }
            sijainti += a;
        }

        // Tähän manuaalisesti kaikki sijainnit...
        if (sijainti.equals("A1")) {
            return new SijaintiA1(tiedot);
        } else if (sijainti.equals("A2")) {
            return new SijaintiA2(tiedot);
        }

        return null;
    }

    private void luoSkanneri() throws FileNotFoundException {
        this.scanner = new Scanner(new File(save));
    }
}
