package Sovelluslogiikka.Kuuntelijat;

import Kayttoliittyma.Toiminnot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Item-valikkonäppäimen painallusten kuuntelu.
 *
 */
public class ButtonItemsListener implements ActionListener {

    private Toiminnot tiedot;

    public ButtonItemsListener(Toiminnot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.itemit();
    }
}
