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

        creeTabBoutonChiffre(ecran);
        creeTabBoutonOperation(ecran);
        activeBoutons(boutonChiffre);
        activeBoutons(boutonOperation);

        console.setPreferredSize(new Dimension(width - 10, height - 10));
        console.setLayout(new BorderLayout());

        console.add(manageBoutons(boutonChiffre, (int)((6 * width) / 10), height, 4, 3), BorderLayout.CENTER);
        console.add(manageBoutons(boutonOperation, (int)(4 * width / 10), height, 4, 2), BorderLayout.EAST);

        setBackground(new Color(198, 231, 253));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(console);
    }

    public void creeTabBoutonChiffre(Ecran ecran) {
        int j = 0;

        boutonChiffre = new Bouton[12];

        // Chiffres de 0 - 9
        for (int i = 9; i >= 0; i--) {
            boutonChiffre[i] = new Bouton("" + (j++), ecran);
        }

        // extensions de bouton chiffre
        boutonChiffre[10] = new Bouton("00", ecran);
        boutonChiffre[11] = new Bouton(".", ecran);
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

    public void activeBoutons(Bouton[] boutonTab) {
        for (Bouton b : boutonTab) {
            b.addActionListener( e -> {
                b.faitSurClique();
                System.out.println(b.getEcranCible().getAffichage());
            });
        }
    }

    public JPanel manageBoutons(Bouton[] boutonTab, int width, int height, int row, int col) {
        JPanel  panel = new JPanel();

        panel.setLayout(new GridLayout(row, col));
        panel.setPreferredSize(new Dimension(width, height));

        for (Bouton b : boutonTab) {
            panel.add(b);
            b.setFont(new Font("Segoe UI", Font.BOLD, 15));
        }
        return panel;
    }
}
