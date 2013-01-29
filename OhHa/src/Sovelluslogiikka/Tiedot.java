package Sovelluslogiikka;

import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.kuuntelijat.buttonEteneListener;
import Sovelluslogiikka.kuuntelijat.buttonExamineListener;
import Sovelluslogiikka.kuuntelijat.buttonUseListener;
import Sovelluslogiikka.kuuntelijat.kaannyOikeaListener;
import Sovelluslogiikka.kuuntelijat.kaannyVasenListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tiedot {

    private Tallennus tallennus;
    private Lataaja lataaja;
    private Ruutu ruutu;
    private Suunta suunta;
    private Sijainti sijainti;
    private Container container;
    private CardLayout cardlayout;
    private JPanel jpanel;
    private JButton kayta;
    private JButton tutki;
    private JButton etene;
    private JButton tallenna;
    private JButton lataa;
    private JLabel ylapalkki;

    public Tiedot() {
        this.cardlayout = new CardLayout();

    }

    public void lataa(Container container) {
        this.container = container;

        this.lataaja = new Lataaja();

        this.tallennus = lataaja.lataaTallennus();

        if (this.tallennus == null) {
            this.tallennus = new Tallennus();
            this.suunta = Suunta.POHJOINEN;
            sijainti = new SijaintiA1(this);
        }

        this.paivita();
        this.paivitaButtonit();

    }

    public void seuraavaRuutu() {
        Sijainti next = sijainti.liiku(suunta);

        if (next == null) {
        } else {
            sijainti = next;
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
        JPanel tausta = new JPanel(new BorderLayout());
        tausta.setBackground(Color.black);

        JPanel alaosa = new JPanel(new GridLayout(1, 5));
        JPanel ylaosa = new JPanel(new GridLayout());
        ylaosa.setBackground(Color.black);
        this.ylapalkki = new JLabel();
        ylapalkki.setForeground(Color.white);
        ylaosa.add(ylapalkki);


        tausta.add(ylaosa, BorderLayout.NORTH);
        tausta.add(jpanel);
        tausta.add(alaosa, BorderLayout.SOUTH);

        // Buttonit
        this.kayta = new JButton("Käytä");
        kayta.setBackground(Color.black);
        kayta.setForeground(Color.white);
        kayta.addActionListener(new buttonUseListener(this));
        kayta.setBorderPainted(false);

        this.tutki = new JButton("Tutki");
        tutki.setBackground(Color.black);
        tutki.setForeground(Color.white);
        tutki.addActionListener(new buttonExamineListener(this));
        tutki.setBorderPainted(false);

        this.etene = new JButton("Etene");
        etene.setBackground(Color.black);
        etene.setForeground(Color.white);
        etene.addActionListener(new buttonEteneListener(this));

        this.tallenna = new JButton("Tallenna");
        tallenna.setBackground(Color.black);
        tallenna.setForeground(Color.white);
        tallenna.setBorderPainted(false);

        this.lataa = new JButton("Lataa");
        lataa.setBackground(Color.black);
        lataa.setForeground(Color.white);
        lataa.setBorderPainted(false);

        JButton oikea = new JButton();
        oikea.addActionListener(new kaannyOikeaListener(this));
        oikea.setPreferredSize(new Dimension(20, 640));
        oikea.setOpaque(false);
        oikea.setContentAreaFilled(false);
        oikea.setBorderPainted(false);
        ImageIcon tyhjaIcon = new ImageIcon(getClass().getResource("buttonIcons/tyhja.gif"));
        ImageIcon oikeaIcon = new ImageIcon(getClass().getResource("buttonIcons/oikea.gif"));
        oikea.setIcon(tyhjaIcon);
        oikea.setRolloverIcon(oikeaIcon);
        oikea.setFocusPainted(false);

        JButton vasen = new JButton();
        vasen.addActionListener(new kaannyVasenListener(this));
        vasen.setPreferredSize(new Dimension(20, 640));
        vasen.setOpaque(false);
        vasen.setContentAreaFilled(false);
        vasen.setBorderPainted(false);
        ImageIcon vasenIcon = new ImageIcon(getClass().getResource("buttonIcons/vasen.gif"));
        vasen.setIcon(tyhjaIcon);
        vasen.setRolloverIcon(vasenIcon);
        vasen.setFocusPainted(false);
        
        
        alaosa.add(kayta);
        alaosa.add(tutki);
        alaosa.add(etene);
        alaosa.add(lataa);
        alaosa.add(tallenna);

        tausta.add(vasen, BorderLayout.WEST);
        tausta.add(oikea, BorderLayout.EAST);

        return tausta;
    }

    public void paivitaButtonit() {

        if (this.ruutu.getNakyma(suunta).onkoKaytettava()) {
            this.kayta.setEnabled(true);
        } else {
            this.kayta.setEnabled(false);
        }

        if (this.ruutu.getNakyma(suunta).onkoLuettava()) {
            this.tutki.setEnabled(true);
        } else {
            this.tutki.setEnabled(false);
        }

        this.ylapalkki.setText("   ");
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
        this.ylapalkki.setText("      " + teksti);
    }

    public String getTeksti() {
        return this.ylapalkki.getText();
    }

    public void kayta() {
        this.sijainti.kayta(suunta);
    }

    public Tallennus getTallennus() {
        return this.tallennus;
    }
}
