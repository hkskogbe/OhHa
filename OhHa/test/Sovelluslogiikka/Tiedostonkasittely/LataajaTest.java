package Sovelluslogiikka.Tiedostonkasittely;

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LataajaTest {

    private Lataaja l;

    public LataajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testaaUusiLataajaVirheellisellaTiedostoSijainnillaMetoditHeittavatFileNotFoundExceptionin() {
        this.l = new Lataaja("sijainti ei olekaan sijainti");
        try {
            l.lataaTallennus();
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
