package composant;

import javax.swing.JButton;

public class Bouton extends JButton {
    private Ecran   ecranCible;
    private String  symbol;

    public Bouton(String symb, Ecran ecran) {
        super(symb);
        symbol = symb;
        ecranCible = ecran;
    }

    public String getSymbol() {
        return symbol;
    }

    public Ecran getEcranCible() {
        return ecranCible;
    }

    public void setEcranCible (Ecran ecran) {
        ecranCible = ecran;
    }

    public void faitSurClique() {
        getEcranCible().ajouteAffichage(getSymbol());
        getEcranCible().refresh();
    }
}