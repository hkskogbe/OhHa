package Sovelluslogiikka.Kuuntelijat;

import Kayttoliittyma.Toiminnot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vasemmalle kääntymisestä huolehtivan painikkeen painallusten kuuntelu.
 *
 */
public class KaannyVasenListener implements ActionListener {

    private Toiminnot tiedot;

    public KaannyVasenListener(Toiminnot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.kaanny(false);
    }
}