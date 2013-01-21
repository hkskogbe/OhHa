
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tiedot;
import java.awt.Container;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TiedotTest {
    
    Tiedot tiedot;
    
    
    
    
    public TiedotTest() {
    }
    
    
    @Before
    public void setUp() {
        this.tiedot = new Tiedot();
        tiedot.lataa(new Container());
        
    }
    @Test
    public void onkoSuuntaOikeaJosEiKaannyta() {
        assertEquals(Suunta.POHJOINEN, this.tiedot.getSuunta());
    }
    @Test
    public void onkoSuuntaOikeaKaannyttaessaOikealle() {
        this.tiedot.kaanny(true);
        assertEquals(Suunta.ITA, this.tiedot.getSuunta());
    }
    @Test
    public void onkoSuuntaOikeaKaannyttaessaVasemmalle() {
        this.tiedot.kaanny(false);
        assertEquals(Suunta.LANSI, this.tiedot.getSuunta());
    }
    @Test
    public void onkoSuuntaOikeaKaannyttaessaOikealleMontaKertaa() {
        this.tiedot.kaanny(true);
        this.tiedot.kaanny(true);
        this.tiedot.kaanny(true);
        assertEquals(Suunta.LANSI, this.tiedot.getSuunta());
    }
    @Test
    public void onkoSuuntaOikeaKaannyttaessaVasemmalleMontaKertaa() {
        this.tiedot.kaanny(false);
        this.tiedot.kaanny(false);
        this.tiedot.kaanny(false);
        assertEquals(Suunta.ITA, this.tiedot.getSuunta());
    }
    
    
    
    
}
