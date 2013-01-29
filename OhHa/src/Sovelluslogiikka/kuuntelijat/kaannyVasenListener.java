
package Sovelluslogiikka.kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class kaannyVasenListener implements ActionListener{
    private Tiedot tiedot;

    public kaannyVasenListener(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.kaanny(false);
    }
}