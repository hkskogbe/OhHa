/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sovelluslogiikka.Ruudut.A2;

import Sovelluslogiikka.Ruudut.A1.SijaintiA1;
import Sovelluslogiikka.Ruudut.Nakyma;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Suunta;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SijaintiA2 implements Sijainti {

    private Ruutu ruutu;

    public SijaintiA2() {
        Nakyma pohjoinen = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A2pohjoinen.jpg")), false);
        Nakyma ita = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A2ita.jpg")), false);
        Nakyma etela = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A2etela.jpg")), false);
        Nakyma lansi = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A2lansi.jpg")), false);

        this.ruutu = new Ruutu(pohjoinen, ita, etela, lansi);
    }

    @Override
    public Sijainti liiku(Suunta suunta) {
        if (suunta == Suunta.POHJOINEN) {
            System.out.println("You hit your head on an invisible wall.");
            return null;
        } else if (suunta == Suunta.ITA) {
            System.out.println("You hit your head on an invisible wall.");
            return null;
        } else if (suunta == Suunta.ETELA) {
            return new SijaintiA1();
        } else {
            System.out.println("You hit your head on an invisible wall.");
            return null;
        }
    }

    @Override
    public Ruutu getRuutu() {
        return this.ruutu;
    }
}