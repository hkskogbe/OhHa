package Kayttoliittyma;

import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tiedot;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Tiedot tiedot;

    public Kayttoliittyma(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.lataaPeli();

        this.frame.addKeyListener(new NappisKuuntelija(this));
        
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
