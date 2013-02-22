/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Sovelluslogiikka.Tavarat.Tavarat;
import java.awt.Container;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 *
 */
public class KayttoliittymanGrafiikkaTest {

    KayttoliittymanGrafiikka x;
    Container c;
    Toiminnot t;
    Tavarat i;

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
        t = new Toiminnot();
        t.lataaUusiPeli(c);
        x = new KayttoliittymanGrafiikka(t);
        x.haeUI(new JPanel());
        i = new Tavarat();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void itemIkkunaDisableeButtonitOikein() {
        x.itemValikko(i, c);
        assertFalse(x.getLataaButton().isEnabled());
    }

    @Test
    public void latausValikkoEiDisableeLataaButtonia() {
        x.latausValikko(t.getTiedot().getTallennuskansio(), c);
        assertTrue(x.getLataaButton().isEnabled());
    }

    @Test
    public void itemIkkunaButtonitEiAlussaDisabled() {
        assertTrue(x.getLataaButton().isEnabled());
    }

    @Test
    public void itemIkkunaPoistaaNappuloidenDisableuksen() {
        x.itemValikko(i, c);
        x.itemValikko(i, c);
        assertTrue(x.getLataaButton().isEnabled());
    }

    @Test
    public void alussaYlaPalkkiTyhjana() {
        x.haeUI(new JPanel());
        String w = x.getYlaPalkinText();
        assertEquals("", w.trim());
    }

    @Test
    public void ylapalkinTekstiMuuttuuKunSitaMuutetaan() {
        x.haeUI(new JPanel());
        x.naytaTeksti("Foo!");
        String w = x.getYlaPalkinText().trim();
        assertEquals("Foo!", w);
    }
    
    @Test
    public void virheellinenLatausvalikonTiedostopolkuEiKaadaOhjelmaa() {
        try {
            x.latausValikko("Eihän tälläistä sijaintia voi olla", c);
        } catch (Exception e) {
            fail("Ei saisi heittää exceptionia");
        }
    }
    
    @Test
    public void virheellinenSijaintiLatausValikkoonMennessäEiIlmoitaVirheestaKayttajalleVaanPiilottaaVirheen() {
        x.latausValikko("Vihrrrllinen tiedostopolku", c);
        String w = x.getYlaPalkinText();
        if (!w.trim().isEmpty()) {
            fail("Yläpalkin tekstin kuuluisi olla tyhjä latausnäkymässä");
        }
    }
    @Test
    public void virheellinenSijaintiTallennusValikkoonMennessäEiIlmoitaVirheestaKayttajalleVaanPiilottaaVirheen() {
        x.tallennusValikko("Vihrrrllinen tiedostopolku", c);
        String w = x.getYlaPalkinText();
        if (!w.trim().isEmpty()) {
            fail("Yläpalkin tekstin kuuluisi olla tyhjä tallennusnäkymässä");
        }
    }
}
