package palikkapeli.grafiikka;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import palikkapeli.pelilogiikka.Tetris;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Tetris tetris;

    public Piirtoalusta(Tetris tetris) {
        this.tetris = tetris;
        super.setBackground(Color.BLACK);
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
