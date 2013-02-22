package Kayttoliittyma;

import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.Klikattava;
import Sovelluslogiikka.Ruudut.KlikattavienHiiriKuuntelija;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tavarat.Tavarat;
import Sovelluslogiikka.Tiedostonkasittely.Lataaja;
import Sovelluslogiikka.Tiedostonkasittely.Tallennus;
import Sovelluslogiikka.Tiedostonkasittely.Tallentaja;
import Sovelluslogiikka.Tiedot;
import java.awt.CardLayout;
import java.awt.Container;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Toiminnot käsittelee pelin käskyjä
 *
 */
public class Toiminnot {

    private Tiedot tiedot;
    private Tallennus tallennus;
    private Lataaja lataaja;
    private Tallentaja tallentaja;

    private Container container;
    private CardLayout cardlayout;
    private JPanel jpanel;
    private KlikattavienHiiriKuuntelija shk;
    private boolean valikkoNakymassa;
    private KayttoliittymanGrafiikka kayttiksenGrafiikka;

    /**
     * Uuden Toiminnot-olion luonti luo myös uuden käytössä olevan layoutin
     * JFramella
     */
    public Toiminnot() {
        this.tiedot = new Tiedot();
        this.cardlayout = new CardLayout();
        this.kayttiksenGrafiikka = new KayttoliittymanGrafiikka(this);
    }

    /**
     * Lataa jo olemassaolevan tallennukset käytettäväksi
     *
     * @param latauskansio
     */
    public void lataa(String latausSijainti) {
        this.lataaja = new Lataaja(this.tiedot.getTallennuskansio() + latausSijainti);
        try {
            this.tallennus = lataaja.lataaTallennus();
            this.tiedot.setSijainti(lataaja.lataaSijainti(this));
            this.tiedot.setSuunta(lataaja.lataaSuunta());
            this.tiedot.setTavarat(lataaja.lataaTavarat());

            this.paivita();
            this.paivitaButtonit();
            this.nayta();

        } catch (Exception e) {
            this.naytaTeksti("Could not find file to load");
        }
    }

    /**
     * Luo uuden tallennuksen sekä tavarat-listan. Asettaa sijainniksi A1 ja
     * suunnaksi pohjoinen.
     *
     * @param container
     */
    public void lataaUusiPeli(Container container) {
        this.container = container;

        this.tallennus = new Tallennus();
        this.tiedot.setSuunta(Suunta.POHJOINEN);
        this.tiedot.setSijainti(new SijaintiA1(this));
        this.tiedot.setTavarat(new Tavarat());

        this.paivita();
        this.paivitaButtonit();

    }

    /**
     * Tallentaa nykyisen pelitilanteen kohdetiedostoon
     *
     * @param kohdetiedosto
     */
    public void tallenna(String kohde) {
        try {
            this.tallentaja = new Tallentaja(kohde);
            try {
                this.tallentaja.tallenna(tallennus, this.tiedot.getSuunta(), this.tiedot.getSijainti().toString(), this.tiedot.getTavarat());
            } catch (URISyntaxException ex) {
                this.naytaTeksti("Save file not found");
            }
            this.kayttiksenGrafiikka.tallennusValikko(this.tiedot.getTallennuskansio(), container);

        } catch (IOException ex) {
            this.naytaTeksti("Error while saving");
        }
    }

    /**
     * Tarkistaa, tuleeko liikuttaessa eteenpäin tämänhetkisestä sijainnista
     * seuraavaa ruutua
     *
     * @return onko eteenpäin liikuttaessa ruutua
     */
    boolean onSeuraavaRuutu() {
        Sijainti onko = this.tiedot.getSijainti().liiku(this.tiedot.getSuunta());
        return (onko != null ? true : false);
    }

    /**
     * Siirtää pelaajahahmoa eteenpäin seuraavaan sijaintiin
     */
    public void seuraavaRuutu() {
        if (onSeuraavaRuutu()) {
            this.tiedot.setSijainti(this.tiedot.getSijainti().liiku(this.tiedot.getSuunta()));
            this.paivita();
            this.nayta();
        }
    }

    /**
     * Kääntää pelihahmoa yhden näkymän vasemmalle tai oikealle
     *
     * @param true = oikea, false = vasen
     */
    public void kaanny(boolean oikea) {
        if (this.tiedot.getSuunta() == Suunta.POHJOINEN) {
            this.tiedot.setSuunta(oikea ? Suunta.ITA : Suunta.LANSI);

        } else if (this.tiedot.getSuunta() == Suunta.ITA) {
            this.tiedot.setSuunta(oikea ? Suunta.ETELA : Suunta.POHJOINEN);

        } else if (this.tiedot.getSuunta() == Suunta.ETELA) {
            this.tiedot.setSuunta(oikea ? Suunta.LANSI : Suunta.ITA);

        } else if (this.tiedot.getSuunta() == Suunta.LANSI) {
            this.tiedot.setSuunta(oikea ? Suunta.POHJOINEN : Suunta.ETELA);
        }

        nayta();
    }

    /**
     * Näyttää suunnan pohjalta tämänhetkisen näkymän
     */
    public void nayta() {
        this.cardlayout.show(jpanel, this.tiedot.getSuunta().toString());
        this.paivitaButtonit();
        this.paivitaKlikattavat();
    }

    /**
     * Hakee nykyiseen näkymään liittyvät klikkauskohteet
     */
    private void paivitaKlikattavat() {
        jpanel.removeMouseListener(shk);
        shk = new KlikattavienHiiriKuuntelija(this, tiedot.getSijainti(), tiedot.getRuutu().getNakyma(tiedot.getSuunta()).getKlikattavat());
        jpanel.addMouseListener(shk);
    }

    /**
     * Asettaa cardlayoutiin ruutu-luokalta saatavien näkymä-luokkien kuvat
     */
    public void paivita() {
        Ruutu ruutu = tiedot.getSijainti().getRuutu();
        
        this.tiedot.setRuutu(ruutu);

        jpanel = new JPanel(cardlayout);

        JLabel pohjoinen = new JLabel(ruutu.getNakyma(Suunta.POHJOINEN).getIcon());
        JLabel ita = new JLabel(ruutu.getNakyma(Suunta.ITA).getIcon());
        JLabel etela = new JLabel(ruutu.getNakyma(Suunta.ETELA).getIcon());
        JLabel lansi = new JLabel(ruutu.getNakyma(Suunta.LANSI).getIcon());

        jpanel.add(pohjoinen, "POHJOINEN");
        jpanel.add(ita, "ITA");
        jpanel.add(etela, "ETELA");
        jpanel.add(lansi, "LANSI");

        container.removeAll();

        JPanel tausta = this.haeUI(jpanel);
        container.add(tausta);

        this.paivitaKlikattavat();
    }

    /**
     *
     * @param jpanel, joka lisätään UI:n keskelle
     * @return Kokonainen graafinen esitys käyttöliittymästä
     */
    private JPanel haeUI(JPanel jpanel) {
        return this.kayttiksenGrafiikka.haeUI(jpanel);
    }

    /**
     * Asettaa käyttöliittymän painikkeita joko enabled true tai false
     */
    public void paivitaButtonit() {
        this.kayttiksenGrafiikka.paivitaButtonit(this.onSeuraavaRuutu(), tiedot.getRuutu(), tiedot.getSuunta());
    }


    /**
     * Asettaa pelille sijainniksi parametreina saatavan uuden sijainnin
     *
     * @param uusiSijainti
     * @param suunta
     */
//    public void setSijainti(Sijainti uusiSijainti, Suunta suunta) {
//        this.sijainti = uusiSijainti;
//        this.suunta = suunta;
//    }

    /**
     * Käyttää tämänhetkisen sijainnin tutki-metodia tämänhetkiselle suunnalle
     */
    public void tutki() {
        this.tiedot.getSijainti().tutki(this.tiedot.getSuunta());
    }

    /**
     * Asettaa pelin tekstipalkkiin viestin
     *
     * @param teksti
     */
    public void naytaTeksti(String teksti) {
        kayttiksenGrafiikka.naytaTeksti(teksti);
    }

    /**
     *
     * @return Palauttaa tämänhetkisen ilmoituksen pelin tekstipalkissa
     */
    public String getTeksti() {
        return this.kayttiksenGrafiikka.getYlaPalkinText();
    }

    /**
     *
     * @return Palauttaa käytössä olevan Tallennus-olion
     */
    public Tallennus getTallennus() {
        return this.tallennus;
    }

    /**
     * Käyttää item-valikko-ominaisuutta
     */
    public void itemit() {
        kayttiksenGrafiikka.itemValikko(tiedot.getTavarat(), container);
    }

    /**
     * Käyttää latausvalikko-ominaisuutta
     */
    public void latausLista() {
        kayttiksenGrafiikka.latausValikko(tiedot.getTallennuskansio(), container);
    }

    /**
     * Ilmoittaa sijainnille käytettävän itemin
     *
     * @param item
     */
    public void kaytaItem(String item) {
        this.itemit();
        this.tiedot.getSijainti().kaytaItem(tiedot.getTavarat(), tiedot.getSuunta(), item);
    }

    /**
     * Lisää tavaran pelaajan käytössä oleviin tavaroihin
     *
     * @param Lisättävä tavara
     */
    public void lisaaItemReppuun(String item) {
        this.tiedot.getTavarat().lisaaTavara(item);
    }

    /**
     * Poistaa tavaran repusta
     *
     * @param Poistettava tavara
     */
    public void poistaItemRepusta(String item) {
        this.tiedot.getTavarat().poista(item);
    }

    /**
     * Asettaa valikkoNakymassa boolean arvon
     *
     * @param Valikkonäkymä, ollaanko nyt valikkonäkymässä
     */
    public void setValikkoNakyma(boolean b) {
        this.valikkoNakymassa = b;
    }

    /**
     * Tieto siitä, ollaanko nyt valikossa.
     * @return Valikkonäkymä, ollaanko nyt valikkonäkymässä
     */
    public boolean valikkoNakyma() {
        return valikkoNakymassa;
    }

    /**
     *
     * @return Palauttaa Tavarat-olion nyt käytössä olevista tavaroista
     */
//    public Tavarat getTavarat() {
//        return tavarat;
//    }

    /**
     * Siirtää tallennusvalikkoon
     */
    public void tallennusLista() {
        this.kayttiksenGrafiikka.tallennusValikko(this.tiedot.getTallennuskansio(), container);
    }

    
//    public String getTallennusKansio() {
//        return tallennusKansio;
//    }

    public void klikkaa(Klikattava k) {
        this.tiedot.getSijainti().klikkaa(tiedot.getTavarat(), k);
    }

    public Tiedot getTiedot() {
        return this.tiedot;
    }
}
