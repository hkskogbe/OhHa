package Sovelluslogiikka.Kuuntelijat;

import Kayttoliittyma.Toiminnot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vie eteenpäin yksittäisen latauskäskyn jollekin String-muotoiselle
 * lataussijainnille.
 *
 */
public class ButtonLoadListener implements ActionListener {

    public Toiminnot tiedot;
    public String latausSijainti;

    public ButtonLoadListener(Toiminnot tiedot, String latausSijainti) {
        this.tiedot = tiedot;
        this.latausSijainti = latausSijainti;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.setValikkoNakyma(false);
        this.tiedot.lataa(latausSijainti);
    }
}
