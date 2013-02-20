package Sovelluslogiikka.Ruudut.A1;

import Sovelluslogiikka.Ruudut.A2.SijaintiA2;
import Sovelluslogiikka.Ruudut.Klikattava;
import Sovelluslogiikka.Ruudut.Nakyma;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tiedostonkasittely.Tallennus;
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
                return null;
            }

        } else if (suunta == Suunta.ITA) {
            return null;

        } else if (suunta == Suunta.ETELA) {
            return null;

        } else {
            return null;
        }
    }

    @Override
    public Ruutu getRuutu() {
        return this.ruutu;
    }

    /**
     * Kuvauksien asettaminen näkymille on tässä toteutettu erillisen metodin
     * avulla
     */
    private void asetaKuvaukset() {
        this.pohjoinen.setTeksti("You see a magical barrier of something.");
        this.etela.setTeksti("Seems you can click the white dot");
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
            tiedot.naytaTeksti("Reppuusi ilmestyi uusi tavara!");
            tiedot.lisaaItemReppuun("Uusi tavara");
        }
        if (k.getNimi().equals("a1switch")) {
            if (a1Switch()) {
                tiedot.naytaTeksti("You've already used the switch");
            } else {
                tallennus.setTrue("a1switch");
                tiedot.naytaTeksti("You hear something nearby");
            }
        }
    }

    private boolean a1Switch() {
        return tallennus.getArvo("a1switch");
    }

    @Override
    public void kaytaItem(String item) {
        if (item.equals("jotain") && tiedot.getSuunta() == Suunta.LANSI) {
        } else {
            tiedot.naytaTeksti("There's a time and place for everything, but not now!");
        }
    }
}
