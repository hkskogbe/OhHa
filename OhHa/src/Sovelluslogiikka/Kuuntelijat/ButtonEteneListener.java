package Sovelluslogiikka.Kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Etene-painikkeen painallusten kuuntelu.
 *
 */
public class ButtonEteneListener implements ActionListener {

    private Tiedot tiedot;

    public ButtonEteneListener(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.seuraavaRuutu();
    }
}
