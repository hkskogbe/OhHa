
import Kayttoliittyma.Kayttoliittyma;
import Kayttoliittyma.Toiminnot;
import javax.swing.SwingUtilities;

public class main {

    public static void main(String[] args) {

        Toiminnot toiminnot = new Toiminnot();

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(toiminnot);
        SwingUtilities.invokeLater(kayttoliittyma);

    }
}
