package composant;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;

public class Calculette extends JPanel {
    private Ecran   ecran;
    private Clavier clavier;

    public Calculette(int width, int height) {
        ecran = new Ecran(width, (int)(height / 5));
        clavier = new Clavier(ecran, width, height - (int)(height / 5));

        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(198, 231, 253));

        setLayout(new BorderLayout());

        add(ecran, BorderLayout.NORTH);
        add(clavier, BorderLayout.SOUTH);
    }

    public Ecran getEcran() {
        return ecran;
    }

    public Clavier getClavier() {
        return clavier;
    }
}