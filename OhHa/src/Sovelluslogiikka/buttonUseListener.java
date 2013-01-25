package Sovelluslogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttonUseListener implements ActionListener {
    private Tiedot tiedot;
    
    buttonUseListener(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.kaanny(true);
    }
    
}
