package Sovelluslogiikka.Ruudut;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KlikattavaTest {

    Klikattava c;

    public KlikattavaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        c = new Klikattava("Coo!", 35, 765, 33);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luodessaUusiKlikattavaLoytyyArvoX() {
        assertEquals(c.getX(), 35);
    }

    @Test
    public void luodessaUusiKlikattavaLoytyyArvoY() {
        assertEquals(c.getY(), 765);
    }

    @Test
    public void luodessaUusiKlikattavaLoytyyArvoD() {
        assertEquals(c.getD(), 33);
    }

    @Test
    public void luodessaUusiKlikattavaLoytyyNimi() {
        assertEquals(c.getNimi(), "Coo!");
    }
}
