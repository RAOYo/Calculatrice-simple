package affichage;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
    public Fenetre(int width, int height) {
        setTitle("Ma Calculette Simple");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}