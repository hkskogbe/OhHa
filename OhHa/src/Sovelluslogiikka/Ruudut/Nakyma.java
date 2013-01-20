
package Sovelluslogiikka.Ruudut;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Nakyma {
    
    private boolean kaytettava;
    private ImageIcon kuva;
    
    public Nakyma(ImageIcon kuva, boolean kaytettava) {
        this.kaytettava = kaytettava;
        this.kuva = kuva;
    }
    
    public Image getKuva() {
        return this.kuva.getImage();
    }
    public Icon getIcon() {
        return this.kuva;
    }
    public void setKaytettava(boolean kaytettava) {
        this.kaytettava = kaytettava;
    }
    // näkymäclassin tehtävänä omistaa taustakuva ja tiedot siitä, miten näkymän kanssa voi toimia (usable? true/false etc)
}
