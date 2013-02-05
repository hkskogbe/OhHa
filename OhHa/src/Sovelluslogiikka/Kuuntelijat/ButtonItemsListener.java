package Sovelluslogiikka.Kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Item-valikkonäppäimen painallusten kuuntelu.
 *
 */
public class ButtonItemsListener implements ActionListener {

    private Tiedot tiedot;

    public ButtonItemsListener(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.itemit();
    }
}
