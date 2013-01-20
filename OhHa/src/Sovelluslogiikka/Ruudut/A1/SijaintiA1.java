package Sovelluslogiikka.Ruudut.A1;

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
            return null;
        } else if (suunta == Suunta.ITA) {
            return null;
        } else if (suunta == Suunta.ETELA) {
            return null;
        } else {
            return null;
        }
    }

    @Override
    public Ruutu getRuutu() {
        return this.ruutu;
    }
}
