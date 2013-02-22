package Kayttoliittyma;

import Sovelluslogiikka.Kuuntelijat.ButtonEteneListener;
import Sovelluslogiikka.Kuuntelijat.ButtonExamineListener;
import Sovelluslogiikka.Kuuntelijat.ButtonItemsListener;
import Sovelluslogiikka.Kuuntelijat.ButtonLoadOptionsListener;
import Sovelluslogiikka.Kuuntelijat.ButtonSaveOptionsListener;
import Sovelluslogiikka.Kuuntelijat.KaannyOikeaListener;
import Sovelluslogiikka.Kuuntelijat.KaannyVasenListener;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tavarat.Tavarat;
import Sovelluslogiikka.Tavarat.TavaratPanel;
import Sovelluslogiikka.Tiedostonkasittely.LatausPanel;
import Sovelluslogiikka.Tiedostonkasittely.TallennusPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.URISyntaxException;
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
    private Toiminnot toiminnot;

    public KayttoliittymanGrafiikka(Toiminnot tiedot) {
        this.toiminnot = tiedot;
    }

    /**
     * Luo käyttöliittymän painikkeita sekä yläpalkin
     *
     * @param jpanel joka lisätään keskelle taustaa
     * @return Palauttaa käyttöliittymän kokonaisuudessaan
     */
    public JPanel haeUI(JPanel jpanel) {
        JPanel tausta = new JPanel(new BorderLayout());
        tausta.setBackground(Color.black);

        JPanel alaosa = new JPanel(new GridLayout(1, 5));
        alaosa.setBackground(Color.black);
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

    /**
     * Päivittää käyttöliittymän päätoimintojen painikkeet joko käytettäviksi,
     * tai disablee ne
     *
     * @param onSeuraavaRuutu onko eteenpäin liikuttaessa ruutua
     * @param ruutu jonka kautta tarkastellaan näkymiä
     * @param suunta-parametrin avulla haetaan ruudusta näkymä, minkä avulla
     * saadaan selville, tarvitseeko painikkeita disableta vai enableta
     */
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

    /**
     * Siirtää pelaajan item-valikkoon tai pois item-valikosta
     *
     * @param container sisältää pelin nykyisen graafisen esityksen
     */
    public void itemValikko(Tavarat tavarat, Container container) {
        if (toiminnot.valikkoNakyma()) {
            toiminnot.paivita();
            toiminnot.setValikkoNakyma(false);
            toiminnot.nayta();

            this.lataaButton.setEnabled(true);
            this.tallennaButton.setEnabled(true);
            this.eteneButton.setEnabled(true);
            toiminnot.paivitaButtonit();

        } else {

            TavaratPanel tp = new TavaratPanel(tavarat);
            tp.listaa(toiminnot);

            container.removeAll();

            JPanel tausta = this.haeUI(tp);
            container.add(tausta);
            toiminnot.setValikkoNakyma(true);

            this.naytaTeksti("   ");
            this.tutkiButton.setEnabled(false);
            this.lataaButton.setEnabled(false);
            this.tallennaButton.setEnabled(false);
            this.eteneButton.setEnabled(false);
        }


    }

    /**
     * Siirtää pelaajan latausvalikkoon tai pois latausvalikosta
     *
     * @param container joka sisältää pelin nykyisen graafisen esityksen
     */
    public void latausValikko(String tallennuskansio, Container container) {
        if (toiminnot.valikkoNakyma()) {
            toiminnot.paivita();
            toiminnot.setValikkoNakyma(false);
            toiminnot.nayta();

            this.itemitButton.setEnabled(true);
            this.tallennaButton.setEnabled(true);
            this.eteneButton.setEnabled(true);
            toiminnot.paivitaButtonit();

        } else {

            LatausPanel lp;
            try {
                lp = new LatausPanel(tallennuskansio);
                lp.listaa(toiminnot);

                container.removeAll();

                JPanel tausta = this.haeUI(lp);
                container.add(tausta);
                toiminnot.setValikkoNakyma(true);

                this.naytaTeksti("   ");
                this.tutkiButton.setEnabled(false);
                this.itemitButton.setEnabled(false);
                this.tallennaButton.setEnabled(false);
                this.eteneButton.setEnabled(false);
            } catch (URISyntaxException ex) {
                toiminnot.naytaTeksti("Please make sure that the directory /Tallennukset exists.");
            }

        }
    }

    /**
     * Siirtää pelaajan tallennusvalikkoon tai pois tallennusvalikosta
     *
     * @param container joka sisältää pelin nykyisen graafisen esityksen
     * @param tallennuskansio 
     */
    public void tallennusValikko(String tallennuskansio, Container container) {
        if (toiminnot.valikkoNakyma()) {
            toiminnot.paivita();
            toiminnot.setValikkoNakyma(false);
            toiminnot.nayta();

            this.itemitButton.setEnabled(true);
            this.lataaButton.setEnabled(true);
            this.eteneButton.setEnabled(true);
            toiminnot.paivitaButtonit();

        } else {

            TallennusPanel tp;
            try {
                tp = new TallennusPanel(tallennuskansio);
                tp.listaa(toiminnot, tallennuskansio);

                container.removeAll();

                JPanel tausta = this.haeUI(tp);
                container.add(tausta);
                toiminnot.setValikkoNakyma(true);

                this.naytaTeksti("   ");
                this.tutkiButton.setEnabled(false);
                this.itemitButton.setEnabled(false);
                this.lataaButton.setEnabled(false);
                this.eteneButton.setEnabled(false);
            } catch (URISyntaxException ex) {
                toiminnot.naytaTeksti("Please make sure that the directory Tallennukset exists.");
            }

        }

    }

    /**
     * Asettaan parametrina saadun tekstin pelin tekstipalkin tekstiksi
     *
     * @param teksti
     */
    public void naytaTeksti(String teksti) {
        this.ylapalkki.setText("      " + teksti);
    }

    /**
     *
     * @return Palauttaa tällä hetkellä pelissä näytettävän tekstin
     */
    public String getYlaPalkinText() {
        return this.ylapalkki.getText();
    }

    JButton getLataaButton() {
        return lataaButton;
    }

    /**
     * Luo pelinäkymän alaosan valikkonäppäimet ja antaa niille actionlistenerit
     */
    private void luoValikkoButtonit() {
        this.itemitButton = new JButton("Items");
        itemitButton.setBackground(Color.black);
        itemitButton.setForeground(Color.white);
        itemitButton.addActionListener(new ButtonItemsListener(toiminnot));
        itemitButton.setBorderPainted(false);

        this.tutkiButton = new JButton("Examine");
        tutkiButton.setBackground(Color.black);
        tutkiButton.setForeground(Color.white);
        tutkiButton.setFocusable(false);
        tutkiButton.addActionListener(new ButtonExamineListener(toiminnot));
        tutkiButton.setBorderPainted(false);

        this.eteneButton = new JButton("Forward");
        eteneButton.setBackground(Color.black);
        eteneButton.setForeground(Color.white);
        eteneButton.addActionListener(new ButtonEteneListener(toiminnot));

        this.tallennaButton = new JButton("Save");
        tallennaButton.setBackground(Color.black);
        tallennaButton.setForeground(Color.white);
        tallennaButton.setBorderPainted(false);
        tallennaButton.addActionListener(new ButtonSaveOptionsListener(toiminnot));

        this.lataaButton = new JButton("Load");
        lataaButton.setBackground(Color.black);
        lataaButton.setForeground(Color.white);
        lataaButton.setBorderPainted(false);
        lataaButton.addActionListener(new ButtonLoadOptionsListener(toiminnot));
    }

    /**
     * Luo uuden JButtonin, jonka painaminen kääntää pelaajan suuntaa vasemmalle
     *
     * @return Valmis vasemmallekääntymispainike
     */
    private JButton getVasenButton() {
        JButton vasen = new JButton();
        vasen.addActionListener(new KaannyVasenListener(toiminnot));
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

    /**
     * Luo uuden JButtonin, jonka painaminen kääntää pelaajan suuntaa oikealle
     *
     * @return Valmis oikeallekääntymispainike
     */
    private JButton getOikeaButton() {
        JButton oikea = new JButton();
        oikea.addActionListener(new KaannyOikeaListener(toiminnot));
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
