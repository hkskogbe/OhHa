package Kayttoliittyma;

import Sovelluslogiikka.Kuuntelijat.ButtonSaveListener;
import Sovelluslogiikka.Tiedot;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
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
    TallennusPanel(String kansio) {
        this.setLayout(new GridLayout(10, 2));
        this.setBackground(Color.black);
        File sijainti = new File(kansio);
        this.tallennusLista = sijainti.listFiles();
    }

    /**
     * Listaa TallennusPaneliin jo olemassaolevat tallennustiedostot
     * klikattavina JButtoneina
     *
     * @param tiedot
     */
    public void listaa(Tiedot tiedot) {
        JLabel otsikko = new JLabel("Choose file to overwrite");
        otsikko.setForeground(Color.white);
        this.add(otsikko);
        this.add(new JLabel(" "));

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
            t.addActionListener(new ButtonSaveListener(tiedot, "src/Tallennukset/" + o + ".txt"));
            // joku erillinen new save -buttoni olis jees

            this.add(t);
        }
    }
}
