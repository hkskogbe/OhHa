package Sovelluslogiikka.Ruudut;

/**
 * Klikattava-oliot kuvaavat näytöllä olevia klikattavia objekteja. Niillä on
 * nimi, x,y-koordinaatit sekä klikkauksen säde koordinaateista.
 *
 */
public class Klikattava {

    private String nimi;
    private int y;
    private int x;
    private int d;

    public Klikattava(String nimi, int x, int y, int d) {
        this.nimi = nimi;
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public String getNimi() {
        return nimi;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getD() {
        return d;
    }
}
