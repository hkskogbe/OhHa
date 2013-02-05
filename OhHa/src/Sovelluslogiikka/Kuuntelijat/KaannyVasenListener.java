package Sovelluslogiikka.Kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Vasemmalle kääntymisestä huolehtivan painikkeen painallusten kuuntelu.
 *
 */
public class KaannyVasenListener implements ActionListener {

    private Tiedot tiedot;

    public KaannyVasenListener(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.kaanny(false);
    }
}