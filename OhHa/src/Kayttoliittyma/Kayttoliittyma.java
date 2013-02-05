package Kayttoliittyma;

import Sovelluslogiikka.Tiedot;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Kayttoliittyma-luokka luo pohjan pelin graafiselle toteutukselle.
 *
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Container container;
    private Tiedot tiedot;

    public Kayttoliittyma(Tiedot tiedot) {
        this.tiedot = tiedot;
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

    public void lataaPeli() {
        this.tiedot.lataa(frame.getContentPane());
    }

    public void kaanny(boolean oikea) {
        tiedot.kaanny(oikea);
    }

    public void liikuEteenpain() {
        this.tiedot.seuraavaRuutu();
    }
}
