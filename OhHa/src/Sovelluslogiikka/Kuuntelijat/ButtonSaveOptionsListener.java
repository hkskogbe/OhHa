package Sovelluslogiikka.Kuuntelijat;

import Kayttoliittyma.Toiminnot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Avaa tallennusvalikon.
 *
 */
public class ButtonSaveOptionsListener implements ActionListener{

    private Toiminnot tiedot;

    public ButtonSaveOptionsListener(Toiminnot tiedot) {
        this.tiedot = tiedot;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.tallennusLista();
    }

}
