package Sovelluslogiikka;

import Kayttoliittyma.KayttoliittymanGrafiikka;
import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.KlikattavienHiiriKuuntelija;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Tavarat.Tavarat;
import java.awt.CardLayout;
import java.awt.Container;
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
    private Ruutu ruutu;
    private Suunta suunta;
    private Sijainti sijainti;
    private Container container;
    private CardLayout cardlayout;
    private JPanel jpanel;
    private JLabel ylapalkki;
    private KlikattavienHiiriKuuntelija shk;
    private Tavarat tavarat;
    private boolean itemValikko;
    private KayttoliittymanGrafiikka kayttiksenGrafiikka;

    public Tiedot() {
        this.cardlayout = new CardLayout();
        this.kayttiksenGrafiikka = new KayttoliittymanGrafiikka(this);
    }

    public void lataa(Container container) {
        this.container = container;

        this.lataaja = new Lataaja();

        this.tallennus = lataaja.lataaTallennus();

        if (this.tallennus == null) {
            this.tallennus = new Tallennus();
            this.suunta = Suunta.POHJOINEN;
            sijainti = new SijaintiA1(this);
            this.tavarat = new Tavarat();
            tavarat.lisaaTavara("Escape Rope");
            tavarat.lisaaTavara("Rare Candy");
        }

        this.paivita();
        this.paivitaButtonit();

    }

    private boolean onSeuraavaRuutu() {
        Sijainti onko = this.sijainti.liiku(suunta);
        return (onko != null ? true : false);
    }

    public void seuraavaRuutu() {
        if (onSeuraavaRuutu()) {
            this.sijainti = sijainti.liiku(suunta);
            this.paivita();
            this.nayta();
        }
    }

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

    public void nayta() {
        this.cardlayout.show(jpanel, this.suunta.toString());
        this.paivitaButtonit();
        this.paivitaKlikattavat();
    }

    private void paivitaKlikattavat() {
        jpanel.removeMouseListener(shk);
        shk = new KlikattavienHiiriKuuntelija(sijainti, ruutu.getNakyma(suunta).getKlikattavat());
        jpanel.addMouseListener(shk);
    }

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

    private JPanel haeUI(JPanel jpanel) {
        return this.kayttiksenGrafiikka.haeUI(jpanel);
    }

    public void paivitaButtonit() {
        this.kayttiksenGrafiikka.paivitaButtonit(this.onSeuraavaRuutu(), ruutu, suunta);
    }

    public Suunta getSuunta() {
        return this.suunta;
    }

    public Ruutu getRuutu() {
        return this.ruutu;
    }

    public void setSijainti(Sijainti uusiSijainti, Suunta suunta) {
        this.sijainti = uusiSijainti;
        this.suunta = suunta;
    }

    public Sijainti getSijainti() {
        return this.sijainti;
    }

    public void tutki() {
        this.sijainti.tutki(suunta);
    }

    public void naytaTeksti(String teksti) {
        kayttiksenGrafiikka.naytaTeksti(teksti);
    }

    public String getTeksti() {
        return this.kayttiksenGrafiikka.getYlaPalkinText();
    }

    public Tallennus getTallennus() {
        return this.tallennus;
    }

    public void itemit() {
        kayttiksenGrafiikka.itemit(container);
    }

    public void kaytaItem(String item) {
        this.itemit();
        this.sijainti.kaytaItem(item);
    }

    public void lisaaItemReppuun(String item) {
        this.tavarat.lisaaTavara(item);
    }

    public void poistaItemRepusta(String item) {
        this.tavarat.poista(item);
    }

    public void setItemValikko(boolean b) {
        this.itemValikko = b;
    }

    public boolean itemValikko() {
        return itemValikko;
    }

    public Tavarat getTavarat() {
        return tavarat;
    }
}
