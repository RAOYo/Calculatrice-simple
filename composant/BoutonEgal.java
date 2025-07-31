package composant;

public class BoutonEgal extends Operateur {
    public BoutonEgal(Ecran ecran) {
        super("=", ecran);
    }

    @Override
    public void faitSurClique() {
        getEcranCible().faireCalcul();
        getEcranCible().refresh();
    }
}