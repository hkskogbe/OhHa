package Sovelluslogiikka;


import Kayttoliittyma.Toiminnot;
import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.A2.SijaintiA2;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Tiedostonkasittely.Tallennus;
import java.awt.Container;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ToiminnotTest {

    Toiminnot toiminnot;
    Tiedot tiedot;

    public ToiminnotTest() {
    }

    @Before
    public void setUp() {
        this.toiminnot = new Toiminnot();
        tiedot = toiminnot.getTiedot();
        toiminnot.lataaUusiPeli(new Container());

    }

    @Test
    public void onkoSuuntaOikeaJosEiKaannyta() {
        assertEquals(Suunta.POHJOINEN, tiedot.getSuunta());
    }

    @Test
    public void onkoSuuntaOikeaKaannyttaessaOikealle() {
        this.toiminnot.kaanny(true);
        assertEquals(Suunta.ITA, this.tiedot.getSuunta());
    }

    @Test
    public void onkoSuuntaOikeaKaannyttaessaVasemmalle() {
        this.toiminnot.kaanny(false);
        assertEquals(Suunta.LANSI, this.tiedot.getSuunta());
    }

    @Test
    public void onkoSuuntaOikeaKaannyttaessaOikealleMontaKertaa() {
        this.toiminnot.kaanny(true);
        this.toiminnot.kaanny(true);
        this.toiminnot.kaanny(true);
        assertEquals(Suunta.LANSI, this.tiedot.getSuunta());
    }

    @Test
    public void onkoSuuntaOikeaKaannyttaessaVasemmalleMontaKertaa() {
        this.toiminnot.kaanny(false);
        this.toiminnot.kaanny(false);
        this.toiminnot.kaanny(false);
        assertEquals(Suunta.ITA, this.tiedot.getSuunta());
    }

    @Test
    public void ylapalkinTekstiNakyyOikein() {
        toiminnot.naytaTeksti("wasdwasdwasd");
        assertEquals(toiminnot.getTeksti().trim(), "wasdwasdwasd");
    }

    @Test
    public void uusiTallennusPalauttaaFalseJosArvoaEiLaitettu() {
        Tallennus t = toiminnot.getTallennus();
        assertFalse(t.getArvo("ei ole arvoja"));
    }

    @Test
    public void josA1switchPaallaNiinKuljettaessaA1PohjoiseenVaihtuuSijaintiA2ksi() {
        Sijainti s = new SijaintiA1(toiminnot);
        Sijainti s2 = new SijaintiA2(toiminnot);
        
        Tallennus t = toiminnot.getTallennus();
        tiedot.setSijainti(s);
        t.setTrue("a1switch");
        toiminnot.seuraavaRuutu();
        
        assertEquals(s2.getClass(), tiedot.getSijainti().getClass());
    }
}
