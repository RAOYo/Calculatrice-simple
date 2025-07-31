package composant;

public class BoutonDel extends Operateur {
    public BoutonDel(Ecran ecran) {
        super("DEL", ecran);
    }

    @Override
    public void faitSurClique() {
        if (getEcranCible().getAffichage().length() > 0 &&
                !(getEcranCible().getAffichage().contains("Syntax Error") || getEcranCible().getAffichage().contains("Infinity") ||
                getEcranCible().getAffichage().contains("NaN"))) {
            int limit = getEcranCible().getAffichage().length() - 1;

            if (getEcranCible().getAffichage().length() >= 2 && getEcranCible().getAffichage()[limit] == " ") {
                limit--;
            }
            getEcranCible().setAffichage(getEcranCible().getAffichage().substring(0, limit));
            getEcranCible().refresh();
        }
    }
}