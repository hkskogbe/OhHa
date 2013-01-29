package Sovelluslogiikka.Ruudut;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Nakyma {

    private boolean kaytettava;
    private ImageIcon kuva;
    private String teksti;
    private boolean luettava;
    private boolean onkoJoTutkittu;

    public Nakyma(ImageIcon kuva, boolean kaytettava) {
        this.kaytettava = kaytettava;
        this.kuva = kuva;
        this.teksti = "";
        this.luettava = false;
        this.onkoJoTutkittu = false;
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
    public boolean onkoLuettava() {
        return this.luettava;
    }

    public void setTeksti(String teksti) {
        this.teksti = teksti;
        this.luettava = true;
    }

    public String getTeksti() {
        this.onkoJoTutkittu = true;
        return this.teksti;
    }
    
    public boolean tutkittu() {
        return this.onkoJoTutkittu;
    }
}
