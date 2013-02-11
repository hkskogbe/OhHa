/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka.Kuuntelijat;

import Sovelluslogiikka.Tiedot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * 
 */
public class ButtonSaveListener implements ActionListener {

    private Tiedot tiedot;
    private String kohde;

    public ButtonSaveListener(Tiedot tiedot, String kohde) {
        this.tiedot = tiedot;
        this.kohde = kohde;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.tallenna(kohde);
    }
}
