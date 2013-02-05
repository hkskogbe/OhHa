package Kayttoliittyma;


import Kayttoliittyma.Kayttoliittyma;
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tiedot;
import java.awt.Container;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KayttoliittymaTest {

    Tiedot tiedot;
    Kayttoliittyma k;

    public KayttoliittymaTest() {
    }

    @Before
    public void setUp() {
        tiedot = new Tiedot();
        k = new Kayttoliittyma(tiedot);
        tiedot.lataa(new Container());
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
