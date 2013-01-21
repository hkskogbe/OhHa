package Sovelluslogiikka.Ruudut.A1;

import Sovelluslogiikka.Ruudut.A2.SijaintiA2;
import Sovelluslogiikka.Ruudut.Nakyma;
import Sovelluslogiikka.Ruudut.Ruutu;
import Sovelluslogiikka.Ruudut.Sijainti;
import Sovelluslogiikka.Suunta;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SijaintiA1 implements Sijainti {

    private Ruutu ruutu;

    public SijaintiA1() {
        Nakyma pohjoinen = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A1pohjoinen.jpg")), false);
        Nakyma ita = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A1ita.jpg")), false);
        Nakyma etela = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A1etela.jpg")), false);
        Nakyma lansi = new Nakyma(new ImageIcon(getClass().getResource("kuvat/A1lansi.jpg")), false);

        this.ruutu = new Ruutu(pohjoinen, ita, etela, lansi);
    }

    @Override
    public Sijainti liiku(Suunta suunta) {
        if (suunta == Suunta.POHJOINEN) {
            return new SijaintiA2();
        } else if (suunta == Suunta.ITA) {
            System.out.println("You hit your head on an invisible wall.");
            return null;
        } else if (suunta == Suunta.ETELA) {
            System.out.println("You hit your head on an invisible wall.");
            return null;
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
