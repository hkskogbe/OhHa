
import Sovelluslogiikka.Ruudut.Nakyma;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Suunta;
import java.awt.Image;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuutuTest {

    Nakyma A;
    Nakyma B;
    Nakyma C;
    Nakyma D;
    Ruutu ruutu;

    public RuutuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        A = new Nakyma((new ImageIcon()), true);
        B = new Nakyma((new ImageIcon()), true);
        C = new Nakyma((new ImageIcon()), true);
        D = new Nakyma((new ImageIcon()), true);
        ruutu = new Ruutu(A, B, C, D);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palauttaakoNakymanPohjoinen() {
        Nakyma palautus = ruutu.getNakyma(Suunta.POHJOINEN);
        assertEquals(palautus, A);
    }
    @Test
    public void palauttaakoNakymanIta() {
        Nakyma palautus = ruutu.getNakyma(Suunta.ITA);
        assertEquals(palautus, B);
    }
    @Test
    public void palauttaakoNakymanEtela() {
        Nakyma palautus = ruutu.getNakyma(Suunta.ETELA);
        assertEquals(palautus, C);
    }
    @Test
    public void palauttaakoNakymanLansi() {
        Nakyma palautus = ruutu.getNakyma(Suunta.LANSI);
        assertEquals(palautus, D);
    }
}
