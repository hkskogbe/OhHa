package Kayttoliittyma;

import Sovelluslogiikka.Lataaja;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Lataaja lataaja;

    public Kayttoliittyma(Lataaja lataaja) {
        this.lataaja = lataaja;
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.lataaPeli();

        this.frame.addKeyListener(new NappisKuuntelija());
        
        frame.pack();
        frame.setVisible(true);
    }

    public void lataaPeli() {
        this.lataaja.lataa(frame);
    }
}
