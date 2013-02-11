/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka.Kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPopupMenu;

/**
 * Avaa latausvalikon.
 * 
 */
public class ButtonLoadOptionsListener implements ActionListener {

    private Tiedot tiedot;
    private JPopupMenu popup;
    
    public ButtonLoadOptionsListener(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        this.tiedot.lataa();
        this.tiedot.latausLista();
    }
}
