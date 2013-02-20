package Sovelluslogiikka;


import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.A2.SijaintiA2;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Tiedostonkasittely.Tallennus;
import java.awt.Container;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TiedotTest {

    Tiedot tiedot;

    public TiedotTest() {
    }

    @Before
    public void setUp() {
        this.tiedot = new Tiedot();
        tiedot.lataaUusiPeli(new Container());

    }

    @Test
    public void onkoSuuntaOikeaJosEiKaannyta() {
        assertEquals(Suunta.POHJOINEN, this.tiedot.getSuunta());
    }

    @Test
    public void onkoSuuntaOikeaKaannyttaessaOikealle() {
        this.tiedot.kaanny(true);
        assertEquals(Suunta.ITA, this.tiedot.getSuunta());
    }

    @Test
    public void onkoSuuntaOikeaKaannyttaessaVasemmalle() {
        this.tiedot.kaanny(false);
        assertEquals(Suunta.LANSI, this.tiedot.getSuunta());
    }

    @Test
    public void onkoSuuntaOikeaKaannyttaessaOikealleMontaKertaa() {
        this.tiedot.kaanny(true);
        this.tiedot.kaanny(true);
        this.tiedot.kaanny(true);
        assertEquals(Suunta.LANSI, this.tiedot.getSuunta());
    }

    @Test
    public void onkoSuuntaOikeaKaannyttaessaVasemmalleMontaKertaa() {
        this.tiedot.kaanny(false);
        this.tiedot.kaanny(false);
        this.tiedot.kaanny(false);
        assertEquals(Suunta.ITA, this.tiedot.getSuunta());
    }

    @Test
    public void ylapalkinTekstiNakyyOikein() {
        tiedot.naytaTeksti("wasdwasdwasd");
        assertEquals(tiedot.getTeksti().trim(), "wasdwasdwasd");
    }

    @Test
    public void uusiTallennusPalauttaaFalseJosArvoaEiLaitettu() {
        Tallennus t = tiedot.getTallennus();
        assertFalse(t.getArvo("ei ole arvoja"));
    }

    @Test
    public void josA1switchPaallaNiinKuljettaessaA1PohjoiseenVaihtuuSijaintiA2ksi() {
        Sijainti s = new SijaintiA1(tiedot);
        Sijainti s2 = new SijaintiA2(tiedot);
        
        Tallennus t = tiedot.getTallennus();
        tiedot.setSijainti(s, Suunta.POHJOINEN);
        t.setTrue("a1switch");
        tiedot.seuraavaRuutu();
        
        assertEquals(s2.getClass(), tiedot.getSijainti().getClass());
    }
}
