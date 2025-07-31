package composant;

import operation.SystemCalc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Ecran extends JPanel {
    private String  affichage;
    private JLabel  label;
    private JPanel  panel;

    public Ecran(int width, int height) {
        affichage = "";
        label = new JLabel(affichage);
        panel = new JPanel();

        label.setFont(new Font("Segoe UI", Font.PLAIN, 30));

        panel.setPreferredSize(new Dimension(width - 10, height - 10));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

        setBackground(new Color(198, 231, 253));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel);
    }

    public String getAffichage() {
        return affichage;
    }

    public void setAffichage(String aff) {
        affichage = aff;
    }

    public void ajouteAffichage(String str) {
        if (!(affichage.contains("Syntax Error") || affichage.contains("Infinity") || affichage.contains("NaN"))) {
            affichage = affichage + str;
        }
    }

    public void faireCalcul() {
        String[]    partition = affichage.trim().split("\\s+");

        switch (partition.length) {
            case 3:
                try {
                    setAffichage("" + SystemCalc.strCalc(partition[0], partition[2], partition[1]));
                } catch (NumberFormatException e) {
                    setAffichage("Syntax Error");
                }
                break;
            case 1:
                if (getAffichage().contains("+") || getAffichage().contains("-") ||
                        getAffichage().contains("*") || getAffichage().contains("/") || getAffichage().contains("^")) {
                    setAffichage("Syntax Error");
                }
                break;
            default:
                setAffichage("Syntax Error");
                break;
        }
    }

    public void refresh() {
        remove(panel);

        label = new JLabel(getAffichage());
        panel = new JPanel();

        label.setFont(new Font("Segoe UI", Font.PLAIN, 30));

        panel.setPreferredSize(new Dimension((int)getWidth() - 10, (int)getHeight() - 10));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

        setBackground(new Color(198, 231, 253));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(panel);
        revalidate();
        repaint();
    }
}