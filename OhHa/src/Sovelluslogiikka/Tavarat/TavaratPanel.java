package Sovelluslogiikka.Tavarat;

import Sovelluslogiikka.Tiedot;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * TavaratPanel-luokan tarkoituksena on luoda graafinen esitys käytössä olevista
 * tavaroista.
 *
 */
public class TavaratPanel extends JPanel {

    private Tavarat tavarat;
    private int maxrivit;

    public TavaratPanel(Tavarat tavarat) {
        this.tavarat = tavarat;
        this.maxrivit = 10;
        this.setLayout(new GridLayout(this.maxrivit, 2));
        this.setBackground(Color.black);
    }

    public void listaa(Tiedot tiedot) {
        JLabel otsikko = new JLabel("Items in your inventory");
        otsikko.setForeground(Color.white);
        this.add(otsikko);
        this.add(new JLabel(" "));

        for (String tavara : tavarat.getTavarat()) {
            JButton t = new JButton(tavara);
            t.addActionListener(new ItemListListener(tiedot, tavara));
            t.setBackground(Color.black);
            t.setForeground(Color.white);
            this.add(t);
        }

    }
}
