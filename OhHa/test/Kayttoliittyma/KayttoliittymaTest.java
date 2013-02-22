package Kayttoliittyma;


import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tiedot;
import java.awt.Container;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KayttoliittymaTest {

    Toiminnot toiminnot;
    Kayttoliittyma k;
    Tiedot tiedot;

    public KayttoliittymaTest() {
    }

    @Before
    public void setUp() {
        toiminnot = new Toiminnot();
        tiedot = toiminnot.getTiedot();
        k = new Kayttoliittyma(toiminnot);
        toiminnot.lataaUusiPeli(new Container());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kaannyOikealleToimiiJosAlkusuuntaPohjoinen(){
        k.kaanny(true);
        assertEquals(tiedot.getSuunta(), Suunta.ITA);
    }

    @Test
    public void kaannyVasenToimiiJosAloitetaanSuunnastaPohjoinen() {
        k.kaanny(false);
        assertEquals(tiedot.getSuunta(), Suunta.LANSI);
    }
}
