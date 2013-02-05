package Sovelluslogiikka.Ruudut;

import Sovelluslogiikka.Suunta;

/**
 * Sijainti luo ja sisältää yksittäisen alueen tiedot ja tapahtumat.
 * 
 */

public interface Sijainti {

    public Sijainti liiku(Suunta suunta);
    public Ruutu getRuutu();
    public void tutki(Suunta suunta);
    void tutkiPohjoinen();
    void tutkiIta();
    void tutkiEtela();
    void tutkiLansi();

    public void klikkaa(Klikattava k);
    void luoKlikattavat();

    public void kaytaItem(String item);
}
