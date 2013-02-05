
import Kayttoliittyma.Kayttoliittyma;
import Sovelluslogiikka.Tiedot;
import javax.swing.SwingUtilities;

public class main {

    public static void main(String[] args) {

        Tiedot lataaja = new Tiedot();

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lataaja);
        SwingUtilities.invokeLater(kayttoliittyma);

    }
}
