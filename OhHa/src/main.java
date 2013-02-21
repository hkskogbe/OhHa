
import Kayttoliittyma.Kayttoliittyma;
import Sovelluslogiikka.Tiedot;
import java.io.IOException;
import javax.swing.SwingUtilities;

public class main {

    public static void main(String[] args) throws IOException {

        Tiedot lataaja = new Tiedot();

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lataaja);
        SwingUtilities.invokeLater(kayttoliittyma);

        
//        Lataaja lataaja = new Lataaja("src/saves.txt");
//        Tallennus x = lataaja.lataaTallennus();
//        for (String s : x.getArvoLista().keySet()) {
//            System.out.println(s);
//        }
        
        
//        Tallentaja t = new Tallentaja("");
//        Map<String,Boolean> a = new HashMap<String,Boolean>();
//        a.put("ekaAvain", true);
//        a.put("mutTaaOnFalse", false);
//        a.put("dasqsAWkey10001", false);
//        Tavarat ta = new Tavarat();
//        ta.lisaaTavara("wasdtavara");
//        Tallennus tallennus = new Tallennus(a);
//        t.tallenna(tallennus, Suunta.ITA, null, ta);
    }
}
