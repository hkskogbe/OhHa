package Sovelluslogiikka.Ruudut;

import Sovelluslogiikka.Suunta;
import java.io.Serializable;

/**
 * Ruutu on luokka, joka pitää kirjaa yksittäisen sijainnin näkymistä.
 *
 */
public class Ruutu {

    private Nakyma pohjoinen;
    private Nakyma ita;
    private Nakyma etela;
    private Nakyma lansi;

    /**
     * Ruutu saa konstruktorin parametrinaan jokaista pääilmansuuntaa vastaavan
     * näkymä-luokan olion
     *
     * @param pohjoinen
     * @param ita
     * @param etela
     * @param lansi
     */
    public Ruutu(Nakyma pohjoinen, Nakyma ita, Nakyma etela, Nakyma lansi) {
        this.pohjoinen = pohjoinen;
        this.ita = ita;
        this.etela = etela;
        this.lansi = lansi;
    }

    /**
     * Palauttaa suunta-parametrin mukaisen näkymän
     *
     * @param suunta
     * @return Palauttaa suunta-parametrin mukaisen näkymän
     *
     */
    public Nakyma getNakyma(Suunta suunta) {
        return (suunta == Suunta.POHJOINEN ? this.pohjoinen : suunta == Suunta.ITA ? this.ita : suunta == Suunta.ETELA ? this.etela : this.lansi);
    }
}
