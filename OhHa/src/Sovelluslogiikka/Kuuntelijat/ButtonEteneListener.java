package Sovelluslogiikka.Kuuntelijat;

import Kayttoliittyma.Toiminnot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Etene-painikkeen painallusten kuuntelu.
 *
 */
public class ButtonEteneListener implements ActionListener {

    private Toiminnot tiedot;

    public ButtonEteneListener(Toiminnot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.seuraavaRuutu();
    }
}
