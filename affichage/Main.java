package affichage;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import composant.Calculette;

public class Main {
    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre(1000, 600);
        JPanel  conteneur = new JPanel();
        Calculette  calculette = new Calculette(400, 500);

        conteneur.setLayout(new FlowLayout(FlowLayout.CENTER));
        conteneur.add(calculette);

        fenetre.add(conteneur);
    }
}