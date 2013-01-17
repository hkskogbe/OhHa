
import Kayttoliittyma.Kayttoliittyma;
import Sovelluslogiikka.Lataaja;
import javax.swing.SwingUtilities;


public class main {

    public static void main(String[] args) {
        
        Lataaja lataaja = new Lataaja();
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lataaja);
        SwingUtilities.invokeLater(kayttoliittyma);
        
    }
}
