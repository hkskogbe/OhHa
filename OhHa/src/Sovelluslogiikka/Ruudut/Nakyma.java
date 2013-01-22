package Sovelluslogiikka.Ruudut;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Nakyma {

    private boolean kaytettava;
    private ImageIcon kuva;
    private String teksti;

    public Nakyma(ImageIcon kuva, boolean kaytettava) {
        this.kaytettava = kaytettava;
        this.kuva = kuva;
        this.teksti = "";
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

    public boolean onkoKaytettava() {
        return this.kaytettava;
    }

    public void setTeksti(String teksti) {
        this.teksti = teksti;
    }

    public String getTeksti() {
        return this.teksti;
    }
    // näkymäclassin tehtävänä omistaa taustakuva ja tiedot siitä, miten näkymän kanssa voi toimia
}
