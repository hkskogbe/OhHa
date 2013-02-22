package Sovelluslogiikka.Tiedostonkasittely;

import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TallennusPanelTest {
    
    public TallennusPanelTest() {
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
    public void testaaVirheellisellaTiedostollaEttaTallennusPanelToimiiOikeinEikaKaadu() {
        JPanel testipanel = null;
        try {
            testipanel = new TallennusPanel("huono sijainti");
        } catch (Exception e) {
            new AssertionError(testipanel);
            fail("Ei kuuluisi heittää exceptionia");
        }
    }
}
