package Sovelluslogiikka.Tiedostonkasittely;

import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LatausPanelTest {

    public LatausPanelTest() {
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
    public void testaaVirheellisellaTiedostollaEttaLataajaToimiiOikeinEikaKaadu() {
        JPanel testipanel = null;
        try {
            testipanel = new LatausPanel("huono sijainti");
        } catch (Exception e) {
            new AssertionError(testipanel);
            fail("Ei kuuluisi heittää exceptionia");
        }
    }
}
