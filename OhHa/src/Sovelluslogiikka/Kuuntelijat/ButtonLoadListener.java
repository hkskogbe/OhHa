package Sovelluslogiikka.Kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vie eteenpäin yksittäisen latauskäskyn jollekin String-muotoiselle
 * lataussijainnille.
 *
 */
public class ButtonLoadListener implements ActionListener {

    public Tiedot tiedot;
    public String latausSijainti;

    public ButtonLoadListener(Tiedot tiedot, String latausSijainti) {
        this.tiedot = tiedot;
        this.latausSijainti = latausSijainti;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.setLatausValikko(false);
        this.tiedot.lataa(latausSijainti);
    }
}
