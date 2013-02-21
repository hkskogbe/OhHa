package Sovelluslogiikka.Tiedostonkasittely;

import Kayttoliittyma.Toiminnot;
import Sovelluslogiikka.Kuuntelijat.ButtonSaveListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Graafinen esitys tallennusvaihtoehdoista.
 *
 */
public class TallennusPanel extends JPanel {

    private File[] tallennusLista;
    private Scanner scanner;

    /**
     * Luo uuden tallentamiseen erikoistuneen JPanelin
     *
     * @param kansio, johon tallennustiedostot talletetaan
     */
    public TallennusPanel(String kansio) throws URISyntaxException {
        this.setLayout(new GridLayout(10, 2));
        this.setBackground(Color.black);
        URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
        File sijainti = new File(new File(url.toURI()).getParent() + kansio);

        this.tallennusLista = sijainti.listFiles();
    }

    /**
     * Listaa TallennusPaneliin jo olemassaolevat tallennustiedostot
     * klikattavina JButtoneina
     *
     * @param toiminnot
     */
    public void listaa(Toiminnot toiminnot, String tallennuskansio) {
        JLabel otsikko = new JLabel("Choose file to overwrite");
        otsikko.setForeground(Color.white);
        this.add(otsikko);
        this.add(new JLabel(" "));

        if (tallennusLista == null) {
            return;
        }
        
        for (File file : tallennusLista) {
            try {
                this.scanner = new Scanner(file);
            } catch (FileNotFoundException ex) {
                System.out.println("Error scanning file");
            }
            String o = file.getName();
            int pisteenpaikka = o.indexOf(".");
            o = o.substring(0, pisteenpaikka);

            String paivaysString = "";
            try {
                scanner.nextLine();
                paivaysString = scanner.nextLine();
            } catch (Exception e) {
            }

            JButton t = new JButton(o + "   " + paivaysString);
            t.setBackground(Color.black);
            t.setForeground(Color.white);
            t.addActionListener(new ButtonSaveListener(toiminnot, tallennuskansio + o + ".txt"));
            // joku erillinen new save -button tähän kohtaan mahdollisesti

            this.add(t);
        }
    }
}
