package Sovelluslogiikka;

import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
    private Sijainti sijainti;
    private Container container;
    private CardLayout cardlayout;
    private JPanel jpanel;
    private JButton kayta;
    
    public Tiedot() {
        this.eiTallennuksia = true;
        this.cardlayout = new CardLayout();
    }

    public void lataa(Container container) {
        this.container = container;

        if (eiTallennuksia) {
            this.suunta = Suunta.POHJOINEN;
            sijainti = new SijaintiA1();
        }

        this.paivita();
        this.paivitaButtonit();

    }

    public void seuraavaRuutu() {
        Sijainti josNull = this.sijainti;
        sijainti = sijainti.liiku(suunta);

        if (sijainti == null) {
            this.sijainti = josNull;
        }

        this.paivita();
        this.nayta();
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

    private void nayta() {
        this.cardlayout.show(jpanel, this.suunta.toString());
        this.paivitaButtonit();
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
    }

    private JPanel haeUI(JPanel jpanel) {
        JPanel tausta = new JPanel();
        tausta.setLayout(new BorderLayout());

        tausta.add(jpanel);

        // lisätään buttonit alaosaan, gridlayout?
        this.kayta = new JButton("kaanny");
        tausta.add(kayta, BorderLayout.SOUTH);
        kayta.addActionListener(new buttonUseListener(this));

        return tausta;
    }

    private void paivitaButtonit() {
        //tsekkaa, mitä nappuloita on käytettävissä ja disablee joidenkin käytön
        if (this.ruutu.getNakyma(suunta).onkoKaytettava()) {
            this.kayta.setEnabled(true);
        } else {
            this.kayta.setEnabled(false);
        }
        
    }

    public Suunta getSuunta() {
        return this.suunta;
    }
}
