package Grafiikka;

import Pelilogiikka.Tetris;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Tetris tetris;

    public Piirtoalusta(Tetris tetris) {
        this.tetris = tetris;        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void paivita() {
        super.repaint();
    }
}
