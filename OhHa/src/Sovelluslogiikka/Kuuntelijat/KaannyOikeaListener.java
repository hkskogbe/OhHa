package Sovelluslogiikka.Kuuntelijat;

import Kayttoliittyma.Toiminnot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Oikealle kääntymisestä huolehtivan painikkeen kuuntelu.
 *
 */
public class KaannyOikeaListener implements ActionListener {

    private Toiminnot tiedot;

    public KaannyOikeaListener(Toiminnot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.kaanny(true);
    }
}
