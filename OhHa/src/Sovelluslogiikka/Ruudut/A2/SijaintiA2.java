package Sovelluslogiikka.Ruudut.A2;

import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.Klikattava;
import Sovelluslogiikka.Ruudut.Nakyma;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tallennus;
import Sovelluslogiikka.Tiedot;
import javax.swing.ImageIcon;

/**
 * A2 on testisijainti, jonka avulla nähdään, toimiiko siirtyminen ruudusta A1
 * pois. Käy myös pohjasta uusille sijainneille.
 *
 */
public class SijaintiA2 implements Sijainti {

    private Tiedot tiedot;
    private Tallennus tallennus;
    private Ruutu ruutu;
    private Nakyma pohjoinen;
    private Nakyma ita;
    private Nakyma etela;
    private Nakyma lansi;

    public SijaintiA2(Tiedot tiedot) {
        this.tiedot = tiedot;
        this.tallennus = tiedot.getTallennus();

        pohjoinen = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A2pohjoinen.jpg")));
        ita = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A2ita.jpg")));
        etela = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A2etela.jpg")));
        lansi = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A2lansi.jpg")));

        this.ruutu = new Ruutu(pohjoinen, ita, etela, lansi);
    }

    @Override
    public Sijainti liiku(Suunta suunta) {
        if (suunta == Suunta.POHJOINEN) {
            return null;
        } else if (suunta == Suunta.ITA) {
            return null;
        } else if (suunta == Suunta.ETELA) {
            return new SijaintiA1(tiedot);
        } else {
            return null;
        }
    }

    @Override
    public Ruutu getRuutu() {
        return this.ruutu;
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
        tiedot.naytaTeksti(ruutu.getNakyma(Suunta.POHJOINEN).getTeksti());
    }

    @Override
    public void tutkiIta() {
        tiedot.naytaTeksti(ruutu.getNakyma(Suunta.ITA).getTeksti());
    }

    @Override
    public void tutkiEtela() {
        tiedot.naytaTeksti(ruutu.getNakyma(Suunta.ETELA).getTeksti());
    }

    @Override
    public void tutkiLansi() {
        tiedot.naytaTeksti(ruutu.getNakyma(Suunta.LANSI).getTeksti());
    }

    @Override
    public void klikkaa(Klikattava k) {
    }

    @Override
    public void kaytaItem(String item) {
    }

    @Override
    public void luoKlikattavat() {
    }
}