/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka.Kuuntelijat;

import Kayttoliittyma.Toiminnot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * 
 */
public class ButtonSaveListener implements ActionListener {

    private Toiminnot tiedot;
    private String kohde;

    public ButtonSaveListener(Toiminnot tiedot, String kohde) {
        this.tiedot = tiedot;
        this.kohde = kohde;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.tallenna(kohde);
    }
}
