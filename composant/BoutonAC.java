package composant;

public class BoutonAC extends Operateur {
    public BoutonAC(Ecran ecran) {
        super("AC", ecran);
    }

    @Override
    public void faitSurClique() {
        getEcranCible().setAffichage("");
        getEcranCible().refresh();
    }
}