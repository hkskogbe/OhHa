package Sovelluslogiikka.Kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Avaa tallennusvalikon.
 *
 */
public class ButtonSaveOptionsListener implements ActionListener{

    private Tiedot tiedot;

    public ButtonSaveOptionsListener(Tiedot tiedot) {
        this.tiedot = tiedot;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.tallennusLista();
    }

}
