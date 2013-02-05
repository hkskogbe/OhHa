package Sovelluslogiikka.Ruudut.A1;

import Sovelluslogiikka.Ruudut.A2.SijaintiA2;
import Sovelluslogiikka.Ruudut.Klikattava;
import Sovelluslogiikka.Ruudut.Nakyma;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tallennus;
import Sovelluslogiikka.Tiedot;
import javax.swing.ImageIcon;

/**
 * Pelin ensimmäinen alue.
 *
 */
public class SijaintiA1 implements Sijainti {

    private Tiedot tiedot;
    private Tallennus tallennus;
    private Ruutu ruutu;
    private Nakyma pohjoinen;
    private Nakyma ita;
    private Nakyma etela;
    private Nakyma lansi;

    public SijaintiA1(Tiedot tiedot) {
        this.tiedot = tiedot;
        this.tallennus = tiedot.getTallennus();

        pohjoinen = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A1pohjoinen.jpg")));
        ita = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A1ita.jpg")));
        etela = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A1etela.jpg")));
        lansi = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A1lansi.jpg")));

        this.asetaKuvaukset();
        this.luoKlikattavat();

        this.ruutu = new Ruutu(pohjoinen, ita, etela, lansi);
    }

    @Override
    public Sijainti liiku(Suunta suunta) {
        if (suunta == Suunta.POHJOINEN) {
            if (a1Switch()) {
                return new SijaintiA2(tiedot);
            } else {
                tiedot.naytaTeksti("Magical force blocks your movement");
                return null;
            }

        } else if (suunta == Suunta.ITA) {
            tiedot.naytaTeksti("You hit your head on an invisible wall.");
            return null;

        } else if (suunta == Suunta.ETELA) {

            tiedot.naytaTeksti("There seems to be something here.");

            return null;

        } else {
            tiedot.naytaTeksti("You hit your head on an invisible wall.");
            return null;
        }
    }

    @Override
    public Ruutu getRuutu() {
        return this.ruutu;
    }

    private void asetaKuvaukset() {
        this.pohjoinen.setTeksti("You see a magical barrier of something.");
        this.etela.setTeksti("A rusty old switch remains unpressed");
    }

    @Override
    public void luoKlikattavat() {
        this.pohjoinen.setKlikattava(new Klikattava("wasd", 50, 50, 50));
        this.etela.setKlikattava(new Klikattava("a1switch", 500, 100, 50));
    }

    @Override
    public void tutki(Suunta suunta) {
        if (suunta == Suunta.POHJOINEN) {
            this.tutkiPohjoinen();
        } else if (suunta == Suunta.ITA) {
            this.tutkiIta();
        } else if (suunta == Suunta.ETELA) {
            this.tutkiEtela();
        } else {
            this.tutkiLansi();
        }
    }

    @Override
    public void tutkiPohjoinen() {
        if (a1Switch()) {
            tiedot.naytaTeksti("The barrier seems to have weakened");
        } else {
            tiedot.naytaTeksti(ruutu.getNakyma(Suunta.POHJOINEN).getTeksti());
        }
    }

    @Override
    public void tutkiIta() {
        tiedot.naytaTeksti(ruutu.getNakyma(Suunta.ITA).getTeksti());
    }

    @Override
    public void tutkiEtela() {
        if (a1Switch()) {
            tiedot.naytaTeksti("The switch has been activated.");
        } else {
            tiedot.naytaTeksti(ruutu.getNakyma(Suunta.ETELA).getTeksti());
        }
    }

    @Override
    public void tutkiLansi() {
        tiedot.naytaTeksti(ruutu.getNakyma(Suunta.LANSI).getTeksti());
    }

    @Override
    public void klikkaa(Klikattava k) {
        if (k.getNimi().equals("wasd")) {
            tiedot.naytaTeksti("wasd");
        }
        if (k.getNimi().equals("a1switch")) {
            if (a1Switch()) {
                tiedot.naytaTeksti("You've already used the switch");
            } else {
                tallennus.setTrue("A1switch");
                tiedot.naytaTeksti("You hear a not-so-distant sound after using the switch");
            }
        }
    }

    private boolean a1Switch() {
        return tallennus.getArvo("A1switch");
    }

    @Override
    public void kaytaItem(String item) {
        if (item.equals("jotain") && tiedot.getSuunta() == Suunta.LANSI) {
        } else {
            tiedot.naytaTeksti("There's a time and place for everything, but not now!");
        }
    }
}
