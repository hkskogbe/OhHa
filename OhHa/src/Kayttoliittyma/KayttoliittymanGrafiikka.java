package Kayttoliittyma;

import Sovelluslogiikka.Kuuntelijat.ButtonEteneListener;
import Sovelluslogiikka.Kuuntelijat.ButtonExamineListener;
import Sovelluslogiikka.Kuuntelijat.ButtonItemsListener;
import Sovelluslogiikka.Kuuntelijat.KaannyOikeaListener;
import Sovelluslogiikka.Kuuntelijat.KaannyVasenListener;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tavarat.TavaratPanel;
import Sovelluslogiikka.Tiedot;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Luo graafisen toteutuksen käyttöliittymän päätoiminnoille.
 *
 */
public class KayttoliittymanGrafiikka {

    private JButton itemitButton;
    private JButton tutkiButton;
    private JButton eteneButton;
    private JButton tallennaButton;
    private JButton lataaButton;
    private JLabel ylapalkki;
    private Tiedot tiedot;

    public KayttoliittymanGrafiikka(Tiedot tiedot) {
        this.tiedot = tiedot;
    }

    public JPanel haeUI(JPanel jpanel) {
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

        this.luoValikkoButtonit();

        JButton oikea = this.getOikeaButton();
        JButton vasen = this.getVasenButton();

        alaosa.add(itemitButton);
        alaosa.add(tutkiButton);
        alaosa.add(eteneButton);
        alaosa.add(lataaButton);
        alaosa.add(tallennaButton);

        tausta.add(vasen, BorderLayout.WEST);
        tausta.add(oikea, BorderLayout.EAST);

        return tausta;
    }

    public void paivitaButtonit(Boolean onSeuraavaRuutu, Ruutu ruutu, Suunta suunta) {

        if (ruutu.getNakyma(suunta).onkoLuettava()) {
            this.tutkiButton.setEnabled(true);
        } else {
            this.tutkiButton.setEnabled(false);
        }

        if (onSeuraavaRuutu) {
            this.eteneButton.setEnabled(true);
        } else {
            this.eteneButton.setEnabled(false);
        }

        this.ylapalkki.setText("   ");
    }

    public void itemit(Container container) {

        if (tiedot.itemValikko()) {
            tiedot.paivita();
            tiedot.setItemValikko(false);
            tiedot.nayta();

            this.lataaButton.setEnabled(true);
            this.tallennaButton.setEnabled(true);
            this.eteneButton.setEnabled(true);
            tiedot.paivitaButtonit();

        } else {

            TavaratPanel tp = new TavaratPanel(tiedot.getTavarat());
            tp.listaa(tiedot);

            container.removeAll();

            JPanel tausta = this.haeUI(tp);
            container.add(tausta);
            tiedot.setItemValikko(true);

            tiedot.paivitaButtonit();
            this.tutkiButton.setEnabled(false);
            this.lataaButton.setEnabled(false);
            this.tallennaButton.setEnabled(false);
            this.eteneButton.setEnabled(false);
        }

    }

    public void naytaTeksti(String teksti) {
        this.ylapalkki.setText("      " + teksti);
    }

    public String getYlaPalkinText() {
        return this.ylapalkki.getText();
    }

    JLabel getYlapalkki() {
        return this.ylapalkki;
    }

    JButton getLataaButton() {
        return lataaButton;
    }

    private void luoValikkoButtonit() {
        this.itemitButton = new JButton("Items");
        itemitButton.setBackground(Color.black);
        itemitButton.setForeground(Color.white);
        itemitButton.addActionListener(new ButtonItemsListener(tiedot));
        itemitButton.setBorderPainted(false);

        this.tutkiButton = new JButton("Tutki");
        tutkiButton.setBackground(Color.black);
        tutkiButton.setForeground(Color.white);
        tutkiButton.addActionListener(new ButtonExamineListener(tiedot));
        tutkiButton.setBorderPainted(false);

        this.eteneButton = new JButton("Etene");
        eteneButton.setBackground(Color.black);
        eteneButton.setForeground(Color.white);
        eteneButton.addActionListener(new ButtonEteneListener(tiedot));

        this.tallennaButton = new JButton("Tallenna");
        tallennaButton.setBackground(Color.black);
        tallennaButton.setForeground(Color.white);
        tallennaButton.setBorderPainted(false);

        this.lataaButton = new JButton("Lataa");
        lataaButton.setBackground(Color.black);
        lataaButton.setForeground(Color.white);
        lataaButton.setBorderPainted(false);
    }

    private JButton getVasenButton() {
        JButton vasen = new JButton();
        vasen.addActionListener(new KaannyVasenListener(tiedot));
        vasen.setPreferredSize(new Dimension(20, 640));
        vasen.setOpaque(false);
        vasen.setContentAreaFilled(false);
        vasen.setBorderPainted(false);
        ImageIcon vasenIcon = new ImageIcon(getClass().getResource("buttonIcons/vasen.gif"));
        ImageIcon tyhjaIcon = new ImageIcon(getClass().getResource("buttonIcons/tyhja.gif"));
        vasen.setIcon(tyhjaIcon);
        vasen.setRolloverIcon(vasenIcon);
        vasen.setFocusPainted(false);

        return vasen;
    }

    private JButton getOikeaButton() {
        JButton oikea = new JButton();
        oikea.addActionListener(new KaannyOikeaListener(tiedot));
        oikea.setPreferredSize(new Dimension(20, 640));
        oikea.setOpaque(false);
        oikea.setContentAreaFilled(false);
        oikea.setBorderPainted(false);
        ImageIcon tyhjaIcon = new ImageIcon(getClass().getResource("buttonIcons/tyhja.gif"));
        ImageIcon oikeaIcon = new ImageIcon(getClass().getResource("buttonIcons/oikea.gif"));
        oikea.setIcon(tyhjaIcon);
        oikea.setRolloverIcon(oikeaIcon);
        oikea.setFocusPainted(false);
        
        return oikea;
    }
}
