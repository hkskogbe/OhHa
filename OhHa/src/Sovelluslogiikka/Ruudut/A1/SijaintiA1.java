package Sovelluslogiikka.Ruudut.A1;

import Kayttoliittyma.Toiminnot;
import Sovelluslogiikka.Ruudut.A2.SijaintiA2;
import Sovelluslogiikka.Ruudut.Klikattava;
import Sovelluslogiikka.Ruudut.Nakyma;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tavarat.Tavarat;
import Sovelluslogiikka.Tiedostonkasittely.Tallennus;
import javax.swing.ImageIcon;

/**
 * Pelin ensimmäinen alue.
 *
 */
public class SijaintiA1 implements Sijainti {

    private Toiminnot toiminnot;
    private Tallennus tallennus;
    private Ruutu ruutu;
    private Nakyma pohjoinen;
    private Nakyma ita;
    private Nakyma etela;
    private Nakyma lansi;

    public SijaintiA1(Toiminnot tiedot) {
        this.toiminnot = tiedot;
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
                return new SijaintiA2(toiminnot);
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
        this.pohjoinen.setTeksti("You see a really cool invisible barrier.");
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
            toiminnot.naytaTeksti("The no longer very cool barrier seems to be weaker than before");
        } else {
            toiminnot.naytaTeksti(ruutu.getNakyma(Suunta.POHJOINEN).getTeksti());
        }
    }

    @Override
    public void tutkiIta() {
        toiminnot.naytaTeksti(ruutu.getNakyma(Suunta.ITA).getTeksti());
    }

    @Override
    public void tutkiEtela() {
        if (a1Switch()) {
            toiminnot.naytaTeksti("Someone has clicked the dot...");
        } else {
            toiminnot.naytaTeksti(ruutu.getNakyma(Suunta.ETELA).getTeksti());
        }
    }

    @Override
    public void tutkiLansi() {
        toiminnot.naytaTeksti(ruutu.getNakyma(Suunta.LANSI).getTeksti());
    }

    @Override
    public void klikkaa(Tavarat tavarat, Klikattava k) {
        if (k.getNimi().equals("wasd")) {
            if (tavarat.getTavarat().contains("Uusi tavara")) {
                int i = 0;

                for (String s : tavarat.getTavarat()) {
                    if (s.equals("Uusi tavara")) {
                        i++;
                    }
                }

                if (i > 18) {
                    toiminnot.naytaTeksti("Nyt alkaa olla kyllä liikaa tavaroita repussa... Tavara ei enää monistunutkaan!");
                } else {
                    toiminnot.naytaTeksti("Repussasi oleva tavara monistui yllättäen");
                    toiminnot.lisaaItemReppuun("Uusi tavara");
                }

            } else {
                toiminnot.naytaTeksti("Reppuusi ilmestyi uusi tavara!");
                toiminnot.lisaaItemReppuun("Uusi tavara");

            }
        }
        if (k.getNimi().equals("a1switch")) {
            if (a1Switch()) {
                toiminnot.naytaTeksti("You've already clicked the dot, you shouldn't do that too often.");
            } else {
                tallennus.setTrue("a1switch");
                toiminnot.naytaTeksti("You hear the sound of a button behind you becoming clickable");
            }
        }
    }

    private boolean a1Switch() {
        return tallennus.getArvo("a1switch");
    }

    @Override
    public void kaytaItem(Tavarat tavarat, Suunta suunta, String item) {
        if (item.equals("jotain") && suunta == Suunta.LANSI) {
        } else {
            toiminnot.naytaTeksti("There's a time and place for everything, but not now!");
        }
    }
}
