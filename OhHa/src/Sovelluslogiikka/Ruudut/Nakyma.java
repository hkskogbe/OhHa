
package Sovelluslogiikka.Ruudut;

import java.awt.Image;

public class Nakyma {
    
    private boolean kaytettava;
    private Image kuva;
    
    public Nakyma(Image kuva, boolean kaytettava) {
        this.kaytettava = kaytettava;
        this.kuva = kuva;
    }
    
    public Image getKuva() {
        return this.kuva;
    }
    public void setKaytettava(boolean kaytettava) {
        this.kaytettava = kaytettava;
    }
    // näkymäclassin tehtävänä omistaa taustakuva ja tiedot siitä, miten näkymän kanssa voi toimia (usable? true/false etc)
}
