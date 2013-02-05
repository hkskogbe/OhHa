package Sovelluslogiikka;


import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.A2.SijaintiA2;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tallennus;
import Sovelluslogiikka.Tiedot;
import java.awt.Container;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TiedotTest {

    Tiedot tiedot;

    public TiedotTest() {
    }

    @Before
    public void setUp() {
        this.tiedot = new Tiedot();
        tiedot.lataa(new Container());

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
        t.setTrue("A1switch");
        tiedot.seuraavaRuutu();
        
        assertEquals(s2.getClass(), tiedot.getSijainti().getClass());
    }
}
