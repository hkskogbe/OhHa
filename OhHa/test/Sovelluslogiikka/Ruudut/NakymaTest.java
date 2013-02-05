package Sovelluslogiikka.Ruudut;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NakymaTest {

    private Nakyma nakyma;

    public NakymaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.nakyma = new Nakyma(null);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void nakymanTekstiOikeinAluksi() {
        assertEquals("", this.nakyma.getTeksti());
    }

    @Test
    public void nakymanTekstiMuuttuuOikein() {
        this.nakyma.setTeksti("åöä");
        assertEquals("åöä", this.nakyma.getTeksti());
    }

    @Test
    public void heittaaVirheenHaettaessaKuvaaNullImageIconista() {
        try {
            this.nakyma.getKuva();
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void nakymaAlussaTutkimaton() {
        assertFalse(nakyma.tutkittu());
    }

    @Test
    public void nakymaDefaulttinaEiluettava() {
        assertFalse(nakyma.onkoLuettava());
    }

    @Test
    public void josLisataantekstiaNakymalleSiitatuleeLuettava() {
        nakyma.setTeksti("Coo!");
        assertTrue(nakyma.onkoLuettava());
    }

    @Test
    public void nakymaMuuttuututkituksiJostekstiHaetaan() {
        nakyma.setTeksti("Coo!");
        nakyma.getTeksti();
        assertTrue(nakyma.tutkittu());
    }

    @Test
    public void defaulttinaEiKlikattavia() {
        assertTrue(nakyma.getKlikattavat().isEmpty());
    }

    @Test
    public void klikattavaListataanOikein() {
        nakyma.setKlikattava(new Klikattava("Foo!", 45, 63, 55));
        ArrayList<Klikattava> kliks = nakyma.getKlikattavat();
        assertEquals(kliks.get(0).getNimi(), "Foo!");
    }
}
