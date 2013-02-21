package Sovelluslogiikka.Tavarat;

import Kayttoliittyma.Toiminnot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Huolehtii TavaratPanel-luokkaa varten tavaroiden käyttämiskäskyn
 * eteenpäinviemisestä.
 *
 */
public class ItemListListener implements ActionListener {

    private String tavara;
    private Toiminnot tiedot;

    public ItemListListener(Toiminnot tiedot, String tavara) {
        this.tavara = tavara;
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tiedot.kaytaItem(tavara);
    }
}
