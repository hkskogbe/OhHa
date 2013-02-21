/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka.Kuuntelijat;

import Kayttoliittyma.Toiminnot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPopupMenu;

/**
 * Avaa latausvalikon.
 * 
 */
public class ButtonLoadOptionsListener implements ActionListener {

    private Toiminnot tiedot;
    private JPopupMenu popup;
    
    public ButtonLoadOptionsListener(Toiminnot tiedot) {
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        this.tiedot.lataa();
        this.tiedot.latausLista();
    }
}
