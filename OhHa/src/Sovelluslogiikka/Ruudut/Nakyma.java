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

    /**
     * Uusi näkymä
     *
     * @param kuva, näkymän taustakuva
     */
    public Nakyma(ImageIcon kuva) {
        this.kuva = kuva;
        this.teksti = "";
        this.luettava = false;
        this.onkoJoTutkittu = false;
        this.klikattavat = new ArrayList<Klikattava>();
    }

    /**
     *
     * @return Palauttaa Image-olion näkymän kuvasta
     */
    public Image getKuva() {
        return this.kuva.getImage();
    }

    /**
     *
     * @return Palauttaa ImageIcon-version näkymälle asetetusta kuvasta
     */
    public Icon getIcon() {
        return this.kuva;
    }

    /**
     * Kertoo, voiko näkymä-oliota tutkia
     *
     * @return luettavuus
     */
    public boolean onkoLuettava() {
        return this.luettava;
    }

    /**
     * Asettaa näkymä-oliolle tekstin sekä asettaa näkymä-olion tutkittavaksi
     *
     * @param teksti
     */
    public void setTeksti(String teksti) {
        this.teksti = teksti;
        this.luettava = true;
    }

    /**
     * Asettaa näkymäolion tutkituksi ja palauttaa näkymään liittyvän tekstin
     *
     * @return Palauttaa näkymäolioon liittyvän tekstin
     */
    public String getTeksti() {
        this.onkoJoTutkittu = true;
        return this.teksti;
    }

    /**
     * Palauttaa tiedon siitä, onko näkymäolion getTeksti-metodia jo kutsuttu,
     * eli onko näkymää jo aiemmin tutkittu
     *
     * @return Palauttaa tiedo, onko getTeksti-metodia kutsuttu
     */
    public boolean tutkittu() {
        return this.onkoJoTutkittu;
    }

    /**
     * Asettaa näkymälle uuden klikattavan kohteen
     *
     * @param klikattava
     */
    public void setKlikattava(Klikattava klikattava) {
        this.klikattavat.add(klikattava);
    }

    /**
     *
     * @return Palauttaa listan näkymälle asetetuista klikattavista kohteista
     */
    public ArrayList<Klikattava> getKlikattavat() {
        return klikattavat;
    }
}
