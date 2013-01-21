
package Sovelluslogiikka.Ruudut;

import Sovelluslogiikka.Suunta;


public class Ruutu {
    
    private Nakyma pohjoinen;
    private Nakyma ita;
    private Nakyma etela;
    private Nakyma lansi;
    
    public Ruutu(Nakyma pohjoinen, Nakyma ita, Nakyma etela, Nakyma lansi) {
        this.pohjoinen = pohjoinen;
        this.ita = ita;
        this.etela = etela;
        this.lansi = lansi;
    }
    
    public Nakyma getNakyma(Suunta suunta) {
        return (suunta == Suunta.POHJOINEN? this.pohjoinen: suunta == Suunta.ITA? this.ita : suunta == Suunta.ETELA? this.etela: this.lansi);
    }
}
