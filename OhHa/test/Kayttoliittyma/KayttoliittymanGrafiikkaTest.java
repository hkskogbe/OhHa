/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.Tiedot;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hese
 */
public class KayttoliittymanGrafiikkaTest {

    KayttoliittymanGrafiikka x;
    Container c;
    Tiedot t;

    public KayttoliittymanGrafiikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        c = new Container();
        t = new Tiedot();
        t.lataa(c);
        x = new KayttoliittymanGrafiikka(t);
        x.haeUI(new JPanel());

    }

    @After
    public void tearDown() {
    }

    @Test
    public void itemIkkunaDisableeButtonitOikein() {
        x.itemit(c);
        assertFalse(x.getLataaButton().isEnabled());
    }

    @Test
    public void itemIkkunaButtonitEiAlussaDisabled() {
        assertTrue(x.getLataaButton().isEnabled());
    }

    @Test
    public void itemIkkunaPoistaaNappuloidenDisableuksen() {
        x.itemit(c);
        x.itemit(c);
        assertTrue(x.getLataaButton().isEnabled());
    }

    @Test
    public void alussaYlaPalkkiTyhjana() {
        x.haeUI(new JPanel());
        String w = x.getYlapalkki().getText();
        assertEquals("", w.trim());
    }

    @Test
    public void ylapalkinTekstiMuuttuuKunSitaMuutetaan() {
        x.haeUI(new JPanel());
        x.naytaTeksti("Foo!");
        String w = x.getYlaPalkinText().trim();
        assertEquals("Foo!", w);
    }
}
