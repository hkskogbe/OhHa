package Sovelluslogiikka.Ruudut;

import Kayttoliittyma.Toiminnot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * KlikattavienHiiriKuuntelija käsittelee Tiedot-luokalta jokaisen
 * näkymänvaihdon yhteydessä saatavia senhetkiseen Näkymä-olioon liittyviä
 * Klikattavia.
 *
 */
public class KlikattavienHiiriKuuntelija implements MouseListener {

    private ArrayList<Klikattava> klikattavat;
    private Sijainti sijainti;
    private Toiminnot toiminnot;

    /**
     *
     * @param sijainti
     * @param klikattavat
     *  @param toiminnot
     */
    public KlikattavienHiiriKuuntelija(Toiminnot toiminnot, Sijainti sijainti, ArrayList<Klikattava> klikattavat) {
        this.sijainti = sijainti;
        this.klikattavat = klikattavat;
        this.toiminnot = toiminnot;
    }

    /**
     * Tarkistaa jokaisen klikattava-objektin kohdalla, onko hiirievent niiden
     * klikkaussäteen sisällä
     *
     */
    @Override
    public void mousePressed(MouseEvent e) {
        for (Klikattava k : klikattavat) {

            // Jos halutaan käsitellä etäisyyttä k.getD() ympyränmuotoisena säteenä jostakin pisteestä
            if (Math.hypot(e.getX() - k.getX(), e.getY() - k.getY()) < k.getD()) {
                toiminnot.klikkaa(k);
            }

            // Jos taas halutaan käsitellä k.getD():tä neliönmallisena
//            if (e.getX() > (k.getX() - k.getD()) && e.getX() < (k.getX() + k.getD())) {
//                if (e.getY() > (k.getY() - k.getD()) && e.getY() < (k.getY() + k.getD())) {
//
//                    sijainti.klikkaa(k);
//                }
//            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
