package Kayttoliittyma;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Kayttoliittyma-luokka luo pohjan pelin graafiselle toteutukselle.
 *
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Toiminnot toiminnot;

    /**
     * Luo uuden käyttöliittymän
     *
     * @param toiminnot
     */
    public Kayttoliittyma(Toiminnot toiminnot) {
        this.toiminnot = toiminnot;
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(680, 440));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.lataaPeli();

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Kutsuu Toiminnot-luokan metodia luomaan pelin ensimmäisen alueen
     */
    public void lataaPeli() {
        this.toiminnot.lataaUusiPeli(frame.getContentPane());
    }

    /**
     * Kääntää pelihahmon liikkumissuuntaa.
     *
     * @param oikea, oikea = true, false = vasen
     */
    public void kaanny(boolean oikea) {
        toiminnot.kaanny(oikea);
    }

    /**
     * Liikkuu sijainnin määrittämään seuraavaan ruutuun, mikäli se on
     * mahdollista
     */
    public void liikuEteenpain() {
        this.toiminnot.seuraavaRuutu();
    }
}
