package Sovelluslogiikka;

import Kayttoliittyma.KayttoliittymanGrafiikka;
import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.KlikattavienHiiriKuuntelija;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Tavarat.Tavarat;
import Sovelluslogiikka.Tiedostonkasittely.Lataaja;
import Sovelluslogiikka.Tiedostonkasittely.Tallennus;
import Sovelluslogiikka.Tiedostonkasittely.Tallentaja;
import java.awt.CardLayout;
import java.awt.Container;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Tiedot pitää kirjaa pelin tämänhetkisestä tilasta, esimerkiksi suunnasta ja
 * sijainnista.
 *
 */
public class Tiedot {

    private Tallennus tallennus;
    private Lataaja lataaja;
    private Tallentaja tallentaja;
    private Ruutu ruutu;
    private Suunta suunta;
    private Sijainti sijainti;
    private Container container;
    private CardLayout cardlayout;
    private JPanel jpanel;
    private KlikattavienHiiriKuuntelija shk;
    private Tavarat tavarat;
    private boolean valikkoNakymassa;
    private KayttoliittymanGrafiikka kayttiksenGrafiikka;

    /**
     * Uuden tiedot-luokan luonti luo myös uuden käytössä olevan layoutin
     * JFramella
     */
    public Tiedot() {
        this.cardlayout = new CardLayout();
        this.kayttiksenGrafiikka = new KayttoliittymanGrafiikka(this);
    }

    /**
     * Lataa jo olemassaolevan tallennukset käytettäväksi
     *
     * @param latauskansio
     */
    public void lataa(String latausSijainti) {
        this.lataaja = new Lataaja(latausSijainti);
        try {
            this.tallennus = lataaja.lataaTallennus();
            this.sijainti = lataaja.lataaSijainti(this);
            this.suunta = lataaja.lataaSuunta();
            this.tavarat = lataaja.lataaTavarat();

            this.paivita();
            this.paivitaButtonit();
            this.nayta();

        } catch (Exception e) {
            this.naytaTeksti("Could not find file to load");
        }
    }

    /**
     * Luo uuden pelin lataamatta tallennuksia
     *
     * @param container
     */
    public void lataaUusiPeli(Container container) {
        this.container = container;
//
//        this.tallennus = lataaja.lataaTallennus("src/Tallennukset/Default Save.txt");

        this.tallennus = new Tallennus();
        this.suunta = Suunta.POHJOINEN;
        sijainti = new SijaintiA1(this);
        this.tavarat = new Tavarat();

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
            this.tallentaja.tallenna(tallennus, suunta, sijainti.toString(), tavarat);
        } catch (IOException ex) {
            System.out.println("Error while saving");
        }
    }

    /**
     * Tarkistaa, tuleeko liikuttaessa eteenpäin tämänhetkisestä sijainnista
     * seuraavaa ruutua
     *
     * @return onko eteenpäin liikuttaessa ruutua
     */
    private boolean onSeuraavaRuutu() {
        Sijainti onko = this.sijainti.liiku(suunta);
        return (onko != null ? true : false);
    }

    /**
     * Siirtää pelaajahahmoa eteenpäin seuraavaan sijaintiin
     */
    public void seuraavaRuutu() {
        if (onSeuraavaRuutu()) {
            this.sijainti = sijainti.liiku(suunta);
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
        if (this.suunta == Suunta.POHJOINEN) {
            this.suunta = (oikea ? Suunta.ITA : Suunta.LANSI);

        } else if (this.suunta == Suunta.ITA) {
            this.suunta = (oikea ? Suunta.ETELA : Suunta.POHJOINEN);

        } else if (this.suunta == Suunta.ETELA) {
            this.suunta = (oikea ? Suunta.LANSI : Suunta.ITA);

        } else if (this.suunta == Suunta.LANSI) {
            this.suunta = (oikea ? Suunta.POHJOINEN : Suunta.ETELA);
        }

        nayta();
    }

    /**
     * Näyttää suunnan pohjalta tämänhetkisen näkymän
     */
    public void nayta() {
        this.cardlayout.show(jpanel, this.suunta.toString());
        this.paivitaButtonit();
        this.paivitaKlikattavat();
    }

    /**
     * Hakee nykyiseen näkymään liittyvät klikkauskohteet
     */
    private void paivitaKlikattavat() {
        jpanel.removeMouseListener(shk);
        shk = new KlikattavienHiiriKuuntelija(sijainti, ruutu.getNakyma(suunta).getKlikattavat());
        jpanel.addMouseListener(shk);
    }

    /**
     * Asettaa cardlayoutiin ruutu-luokalta saatavien näkymä-luokkien kuvat
     */
    public void paivita() {
        this.ruutu = sijainti.getRuutu();

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
        this.kayttiksenGrafiikka.paivitaButtonit(this.onSeuraavaRuutu(), ruutu, suunta);
    }

    /**
     *
     * @return Palauttaa tämänhetkisen suunnan
     */
    public Suunta getSuunta() {
        return this.suunta;
    }

    /**
     *
     * @return Palauttaa tämänhetkisen ruudun
     */
    public Ruutu getRuutu() {
        return this.ruutu;
    }

    /**
     * Asettaa pelille sijainniksi parametreina saatavan uuden sijainnin
     *
     * @param uusiSijainti
     * @param suunta
     */
    public void setSijainti(Sijainti uusiSijainti, Suunta suunta) {
        this.sijainti = uusiSijainti;
        this.suunta = suunta;
    }

    /**
     *
     * @return Palauttaa nykyisen sijainnin
     */
    public Sijainti getSijainti() {
        return this.sijainti;
    }

    /**
     * Käyttää tämänhetkisen sijainnin tutki-metodia tämänhetkiselle suunnalle
     */
    public void tutki() {
        this.sijainti.tutki(suunta);
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
        kayttiksenGrafiikka.itemValikko(container);
    }

    /**
     * Käyttää latausvalikko-ominaisuutta
     */
    public void latausLista() {
        kayttiksenGrafiikka.latausValikko(container);
    }

    /**
     * Ilmoittaa sijainnille käytettävän itemin
     *
     * @param item
     */
    public void kaytaItem(String item) {
        this.itemit();
        this.sijainti.kaytaItem(item);
    }

    /**
     * Lisää tavaran pelaajan käytössä oleviin tavaroihin
     *
     * @param Lisättävä tavara
     */
    public void lisaaItemReppuun(String item) {
        this.tavarat.lisaaTavara(item);
    }

    /**
     * Poistaa tavaran repusta
     *
     * @param Poistettava tavara
     */
    public void poistaItemRepusta(String item) {
        this.tavarat.poista(item);
    }

    /**
     * Asettaa valikkonäkymään
     *
     * @param Valikkonäkymä, ollaanko nyt valikkonäkymässä
     */
    public void setItemValikko(boolean b) {
        this.valikkoNakymassa = b;
    }

    /**
     *
     * @return Valikkonäkymä, ollaanko nyt valikkonäkymässä
     */
    public boolean itemValikko() {
        return valikkoNakymassa;
    }

    /**
     * Asettaa valikkonäkymään
     *
     * @param Valikkonäkymä, ollaanko nyt valikkonäkymässä
     */
    public void setLatausValikko(boolean b) {
        this.valikkoNakymassa = b;
    }

    /**
     *
     * @return Valikkonäkymä, ollaanko nyt valikkonäkymässä
     */
    public boolean latausValikko() {
        return valikkoNakymassa;
    }

    /**
     *
     * @return Palauttaa Tavarat-olion nyt käytössä olevista tavaroista
     */
    public Tavarat getTavarat() {
        return tavarat;
    }

    /**
     *
     * @return Valikkonäkymä, ollaanko nyt valikkonäkymässä
     */
    public boolean tallennusValikko() {
        return valikkoNakymassa;
    }

    /**
     * Asettaa valikkonäkymään
     *
     * @param Valikkonäkymä, ollaanko nyt valikkonäkymässä
     */
    public void setTallennusValikko(boolean b) {
        this.valikkoNakymassa = b;
    }

    /**
     * Siirtää tallennusvalikkoon
     */
    public void tallennusLista() {
        this.kayttiksenGrafiikka.tallennusValikko(container);
    }
}
