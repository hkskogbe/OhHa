package Sovelluslogiikka.Kuuntelijat;

import Kayttoliittyma.Toiminnot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tutki-painikkeen painallusten kuuntelu;
 *
 */
public class ButtonExamineListener implements ActionListener {

    private Toiminnot tiedot;

    public ButtonExamineListener(Toiminnot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.tutki();
    }
}
