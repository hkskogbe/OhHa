package Sovelluslogiikka;

import java.util.HashMap;
import java.util.Map;

public class Tallennus {

    private Map<String, Boolean> arvot;

    public Tallennus() {
        this.arvot = new HashMap<String, Boolean>();
    }

    public Tallennus(Map<String, Boolean> arvot) {
        this.arvot = arvot;
    }

    public void setTrue(String nimi) {
        this.arvot.put(nimi, true);
    }

    public void setFalse(String nimi) {
        this.arvot.put(nimi, false);
    }

    public boolean getArvo(String haettu) {
        
        for (String nimi : arvot.keySet()) {
            if (nimi.equals(haettu)) {
                return arvot.get(nimi);
            }
        }
        return false;
    }

    public Map<String, Boolean> getArvoLista() {
        return this.arvot;
    }
}
