package Sovelluslogiikka.Ruudut;

import Sovelluslogiikka.Suunta;

public interface Sijainti {

    public Sijainti liiku(Suunta suunta);
    public Ruutu getRuutu();
    public void tutki(Suunta suunta);
    void tutkiPohjoinen();
    void tutkiIta();
    void tutkiEtela();
    void tutkiLansi();

    public void kayta(Suunta suunta);
    void kaytaPohjoinen();
    void kaytaIta();
    void kaytaEtela();
    void kaytaLansi();
}
