package Sovelluslogiikka.Ruudut;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Nakyma pitää sisällään tiedot siitä, kuinka yksittäisen kuvan kanssa pystyy
 * toimimaan.
 *
 */
public class Nakyma {

    private ImageIcon kuva;
    private String teksti;
    private boolean luettava;
    private boolean onkoJoTutkittu;
    private ArrayList<Klikattava> klikattavat;

    public Nakyma(ImageIcon kuva) {
        this.kuva = kuva;
        this.teksti = "";
        this.luettava = false;
        this.onkoJoTutkittu = false;
        this.klikattavat = new ArrayList<Klikattava>();
    }

    public Image getKuva() {
        return this.kuva.getImage();
    }

    public Icon getIcon() {
        return this.kuva;
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

    public void setKlikattava(Klikattava klikattava) {
        this.klikattavat.add(klikattava);
    }

    public ArrayList<Klikattava> getKlikattavat() {
        return klikattavat;
    }
}
