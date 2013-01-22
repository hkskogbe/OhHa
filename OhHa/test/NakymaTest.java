
import Sovelluslogiikka.Ruudut.Nakyma;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        this.nakyma = new Nakyma(null, true);
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

}
