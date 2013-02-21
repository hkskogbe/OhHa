package Sovelluslogiikka.Tiedostonkasittely;

import Sovelluslogiikka.Suunta;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TallentajaTest {

    private Tallentaja t;

    public TallentajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.t = new Tallentaja("huono tiedostonimi");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kirjoitusmuodonTestaajaTrueJosSyotePieniaKirjaimia() {
        assertTrue(t.kirjoitusMuotoOnOikein("pienellakirjoitettusanayhteen"));
    }

    @Test
    public void kirjoitusmuodonTestaajaTrueJosSyotePieniaJaIsojaKirjaimia() {
        assertTrue(t.kirjoitusMuotoOnOikein("pienellaJaIsollaKirjoitettusanaYHTEEN"));
    }

    @Test
    public void kirjoitusmuodonTestaajaIlmoittaaFalseJosSyotteessaIhmeellisiaMerkkeja() {
        assertFalse(t.kirjoitusMuotoOnOikein("pienellaKirj)#¤()¤#&==#¤"));
    }

    @Test
    public void kirjoitusmuodonTestaajaTrueJosSyotePieniaJaIsojaKirjaimiaJaNumeroita() {
        assertTrue(t.kirjoitusMuotoOnOikein("pienellaJaIsollaKirjoitettusanaYHTEEN12345Toimii"));
    }
    
    @Test
    public void tallentajaHeittaaVirheenJosSijaintiHuono() {
        try {
            t.tallenna(null, Suunta.ITA, "no ei tää kyl oo sijainti", null);
            throw new AssertionError(t);
        } catch (Exception e) {
            assertTrue(true);
        }
    
    }
}
