package composant;

public class Operateur extends Bouton {
    public Operateur(String symb, Ecran ecran) {
        super(" " + symb + " ", ecran);
    }

    @Override
    public void faitSurClique() {
        if (getEcranCible().getAffichage().trim().split("\\s+").length >= 3) {
            getEcranCible().faireCalcul();
        }
        getEcranCible().ajouteAffichage(getSymbol());
        getEcranCible().refresh();
    }
}
