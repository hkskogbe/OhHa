package Sovelluslogiikka.kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttonUseListener implements ActionListener {
    private Tiedot tiedot;
    
    public buttonUseListener(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.kayta();
    }
    
}
