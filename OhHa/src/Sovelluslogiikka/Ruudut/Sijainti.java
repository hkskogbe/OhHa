package Sovelluslogiikka.Ruudut;

import Sovelluslogiikka.Suunta;
import Sovelluslogiikka.Tavarat.Tavarat;

/**
 * Sijainti luo ja sisältää yksittäisen alueen tiedot ja tapahtumat.
 *
 */
public interface Sijainti {

    /**
     * Palauttaa seuraavan sijainnin
     *
     * @param suunta
     * @return Seuraava sijainti, null jos seuraavaa sijaintia ei ole
     */
    public Sijainti liiku(Suunta suunta);

    /**
     * Palauttaa sijaintiin liittyvän ruudun
     *
     * @return ruutu
     */
    public Ruutu getRuutu();

    /**
     * Kutsuu suunnan pohjalta oikeaa tutki-metodia
     *
     * @param suunta
     */
    public void tutki(Suunta suunta);
    void tutkiPohjoinen();
    void tutkiIta();
    void tutkiEtela();
    void tutkiLansi();

    /**
     * Suorittaa parametrina saatavan klikattava-olion pohjalta jonkin toiminnon
     *
     * @param klikattava
     * @param tavarat 
     */
    public void klikkaa(Tavarat tavarat, Klikattava klikattava);

    /**
     * Luo jokaiselle näkymälle klikattava-oliot
     */
    void luoKlikattavat();

    /**
     * Suorittaa parametrina saatavan tavaran pohjalta jonkin toiminnon
     *
     * @param Tavara, jota halutaan käyttää
     */
    public void kaytaItem(Suunta suunta, String item);
}
