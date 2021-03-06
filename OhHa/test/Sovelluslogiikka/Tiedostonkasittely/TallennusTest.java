package Sovelluslogiikka.Tiedostonkasittely;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TallennusTest {

    Tallennus t;
    Tallennus t2;
    Map<String, Boolean> lista;

    public TallennusTest() {
    }

    @Before
    public void setUp() {
        this.t = new Tallennus();

        lista = new HashMap<String, Boolean>();
        lista.put("Eka", Boolean.TRUE);
        lista.put("Toka", Boolean.FALSE);
        lista.put("Vika", Boolean.TRUE);
        this.t2 = new Tallennus(lista);
    }

    @Test
    public void uusiArvoSailyySamanaJosYksiArvo() {
        t.setTrue("Uusi");
        assertTrue(t.getArvo("Uusi"));
    }

    @Test
    public void uusiArvoVaihtuuJosArvonArvoaVaihdetaan() {
        t.setTrue("Uusi");
        t.setFalse("Uusi");
        assertFalse(t.getArvo("Uusi"));
    }

    @Test
    public void uusiArvoSailyySamanaJosMontaArvoa() {
        t.setTrue("Uusi");
        t.setTrue("Toinen");
        assertTrue(t.getArvo("Uusi"));
    }

    @Test
    public void mapKonstruktoriArvotOikein() {
        assertTrue(t2.getArvo("Eka"));
        assertFalse(t2.getArvo("Toka"));
    }

    @Test
    public void mapKonstruktoriPalauttaaSamatArvotHaettaessaListaTakaisin() {
        Map<String, Boolean> toinen = t2.getArvoLista();

        assertEquals(lista.get("Eka"), toinen.get("Eka"));
    }

    @Test
    public void eiVoiLisataKahtaSamaaArvoa() {
        boolean x = t2.getArvo("Eka");
        t2.setTrue("Eka");
        boolean z = t2.getArvo("Eka");
        assertEquals(x,z);
    }
}
