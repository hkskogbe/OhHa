
package Kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * NappisKuuntelija käsittelee näppäimistöinputtia. 
 *
 */

public class NappisKuuntelija implements KeyListener{

    private Kayttoliittyma kayttis;
    
    NappisKuuntelija(Kayttoliittyma kayttis) {
        this.kayttis = kayttis;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            kayttis.kaanny(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            kayttis.kaanny(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            kayttis.liikuEteenpain();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
