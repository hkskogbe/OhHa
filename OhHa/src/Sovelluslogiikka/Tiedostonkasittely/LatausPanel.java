package Sovelluslogiikka.Tiedostonkasittely;

import Sovelluslogiikka.Kuuntelijat.ButtonLoadListener;
import Sovelluslogiikka.Tiedot;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Graafinen esitys ladattavista tallennuksista.
 *
 */
public class LatausPanel extends JPanel {

    private File[] tallennusLista;
    private Scanner scanner;

    /**
     * Luo uuden LatausPanelin tallennussijainnista ja asettaa sille layoutin
     * sekä kansion, jossa olevia tiedostoja luetaan
     *
     * @param kansio, jossa olevia tiedostoja luetaan
     */
    public LatausPanel(String kansio) throws URISyntaxException {
        this.setLayout(new GridLayout(10, 2));
        this.setBackground(Color.black);
        URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
        File sijainti = new File(new File(url.toURI()).getParent() + kansio);

        this.tallennusLista = sijainti.listFiles();
    }

    /**
     * Lisää kansiossa olevat ladattavat tiedostot listaksi JButtoneja
     *
     * @param tiedot
     */
    public void listaa(Tiedot tiedot) {

        JLabel otsikko = new JLabel("Choose file to load");
        otsikko.setForeground(Color.white);
        this.add(otsikko);

        JLabel tyhja = new JLabel(" ");
        this.add(tyhja);

        if (tallennusLista == null) {
            return;
        }
        
        for (File file : tallennusLista) {
            try {
                this.scanner = new Scanner(file);
            } catch (FileNotFoundException ex) {
                System.out.println("Error scanning file");
            }
            String filenNimi = file.getName();
            int pisteenpaikka = filenNimi.indexOf(".");
            filenNimi = filenNimi.substring(0, pisteenpaikka);


            String paivaysString = "";
            try {
                scanner.nextLine();
                paivaysString = scanner.nextLine();
            } catch (Exception e) {
            }

            if (!paivaysString.isEmpty()) {
                JButton t = new JButton(filenNimi + "   " + paivaysString);

                t.setBackground(Color.black);
                t.setForeground(Color.white);
                t.addActionListener(new ButtonLoadListener(tiedot, filenNimi + ".txt"));
                this.add(t);
            }
        }

    }
}
