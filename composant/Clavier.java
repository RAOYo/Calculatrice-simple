package composant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class Clavier extends JPanel {
    private Bouton[]    boutonChiffre;
    private Operateur[] boutonOperation;

    public Clavier(Ecran ecran, int width, int height) {
        JPanel  console = new JPanel();
        JPanel  partieChiffre = new JPanel();
        JPanel  partieOperateur = new JPanel();

        creeTabBoutonChiffre(ecran);
        creeTabBoutonOperation(ecran);
        activeBoutons();

        console.setPreferredSize(new Dimension(width - 10, height - 10));
        console.setLayout(new BorderLayout());

        partieChiffre.setLayout(new GridLayout(4, 3));
        partieChiffre.setPreferredSize(new Dimension((int)((3 * width) / 4), height));

        partieOperateur.setLayout(new GridLayout(4, 2));
        partieChiffre.setPreferredSize(new Dimension((int)(width / 4), height));

        for (int i = boutonChiffre.length - 1; i >= 0; i--) {
            partieChiffre.add(boutonChiffre[i]);
            boutonChiffre[i].setFont(new Font("Segoe UI", Font.BOLD, 15));
        }

        for (int i = 0; i < boutonOperation.length; i++) {
            partieOperateur.add(boutonOperation[i]);
            boutonOperation[i].setFont(new Font("Segoe UI", Font.BOLD, 15));
        }

        console.add(partieChiffre, BorderLayout.CENTER);
        console.add(partieOperateur, BorderLayout.EAST);

        setBackground(new Color(198, 231, 253));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(console);
    }

    public void creeTabBoutonChiffre(Ecran ecran) {
        boutonChiffre = new Bouton[12];

        // Chiffres de 0 - 9
        for (int i = 2; i < 12; i++) {
            boutonChiffre[i] = new Bouton("" + (i - 2), ecran);
        }

        // extensions de bouton chiffre
        boutonChiffre[0] = new Bouton(".", ecran);
        boutonChiffre[1] = new Bouton("00", ecran);
    }

    public void creeTabBoutonOperation(Ecran ecran) {
        boutonOperation = new Operateur[8];

        // Operations de base
        boutonOperation[0] = new Operateur("+", ecran);
        boutonOperation[1] = new Operateur("-", ecran);
        boutonOperation[2] = new Operateur("*", ecran);
        boutonOperation[3] = new Operateur("/", ecran);
        boutonOperation[4] = new Operateur("^", ecran);

        // Boutons speciaux
        boutonOperation[5] = new BoutonEgal(ecran);
        boutonOperation[6] = new BoutonAC(ecran);
        boutonOperation[7] = new BoutonDel(ecran);
    }

    public void activeBoutons() {
        for (int i = 0; i < boutonChiffre.length; i++) {
            Bouton  b = boutonChiffre[i];
            b.addActionListener( e -> {
                b.faitSurClique();
                System.out.println(b.getEcranCible().getAffichage());
            });
        }

        for (int i = 0; i < boutonOperation.length; i++) {
            Operateur   o = boutonOperation[i];
            o.addActionListener( e -> {
                o.faitSurClique();
                System.out.println(o.getEcranCible().getAffichage());
            });
        }
    }
}