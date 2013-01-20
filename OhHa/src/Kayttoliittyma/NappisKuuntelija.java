
package Kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
