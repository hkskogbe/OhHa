package Sovelluslogiikka.Kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tutki-painikkeen painallusten kuuntelu;
 *
 */
public class ButtonExamineListener implements ActionListener {

    private Tiedot tiedot;

    public ButtonExamineListener(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.tutki();
    }
}
