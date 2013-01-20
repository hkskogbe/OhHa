package Sovelluslogiikka;

import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tiedot {

    // pitää kirjaa mm. suunnasta ja sijainnista
    // lataamistoiminto sun muu siirretään omaan luokkaansa
    // toistaiseksi luokalla voi olla vähän ylimääräistä tekemistä
    private boolean eiTallennuksia;
    private Ruutu ruutu;
    private Suunta suunta;
    private Sijainti nyt;
    private Container container;
    private CardLayout cardlayout;
    private JPanel jpanel;
    
    public Tiedot() {
        this.eiTallennuksia = true;
        this.cardlayout = new CardLayout();
    }

    public void lataa(Container container) {
        this.container = container;

        if (eiTallennuksia) {
            this.suunta = Suunta.POHJOINEN;
            nyt = new SijaintiA1();
        }
        
        this.paivita();

    }

    public void seuraavaRuutu() {
        nyt = nyt.liiku(suunta);
    }

    public void kaanny(boolean oikea) {
        if (this.suunta == Suunta.POHJOINEN) {
            this.suunta = (oikea? Suunta.ITA : Suunta.LANSI);

        } else if (this.suunta == Suunta.ITA) {
            this.suunta = (oikea? Suunta.ETELA : Suunta.POHJOINEN);

        } else if (this.suunta == Suunta.ETELA) {
            this.suunta = (oikea? Suunta.LANSI : Suunta.ITA);

        } else if (this.suunta == Suunta.LANSI) {
            this.suunta = (oikea? Suunta.POHJOINEN : Suunta.ETELA);
        }
        
        System.out.println(this.suunta);
        
        this.cardlayout.show(jpanel, this.suunta.toString());
    }

    public void paivita() {
        this.ruutu = nyt.getRuutu();
        
        jpanel = new JPanel(cardlayout);
        
        JLabel pohjoinen = new JLabel(ruutu.getNakyma(Suunta.POHJOINEN).getIcon());
        JLabel ita = new JLabel(ruutu.getNakyma(Suunta.ITA).getIcon());
        JLabel etela = new JLabel(ruutu.getNakyma(Suunta.ETELA).getIcon());
        JLabel lansi = new JLabel(ruutu.getNakyma(Suunta.LANSI).getIcon());
        
        jpanel.add(pohjoinen, "POHJOINEN");
        jpanel.add(ita, "ITA");
        jpanel.add(etela, "ETELA");
        jpanel.add(lansi, "LANSI");
        
        container.add(jpanel);
    }
}
