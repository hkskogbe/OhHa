
package Sovelluslogiikka;

import Sovelluslogiikka.Ruudut.A1.RuutuA1;
import Sovelluslogiikka.Ruudut.Ruutu;
import javax.swing.JFrame;

public class Lataaja {
    
    // pitää kirjaa mm. suunnasta ja sijainnista
    
    private boolean eiTallennuksia;
    private Ruutu ruutu;
    private Suunta suunta;
    
    public Lataaja() {
        this.eiTallennuksia = true;
    }

    public void lataa(JFrame frame) {
        if (eiTallennuksia) {
            this.suunta = Suunta.POHJOINEN;
            RuutuA1 ruutuA1 = new RuutuA1(suunta); 
        }
    }
    
}
