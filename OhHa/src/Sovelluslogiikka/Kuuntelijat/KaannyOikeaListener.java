package Sovelluslogiikka.Kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Oikealle kääntymisestä huolehtivan painikkeen kuuntelu.
 *
 */
public class KaannyOikeaListener implements ActionListener {

    private Tiedot tiedot;

    public KaannyOikeaListener(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.kaanny(true);
    }
}
