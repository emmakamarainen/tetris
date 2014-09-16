package Grafiikka;

import Pelilogiikka.Tetris;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {
    private Tetris tetris;

    public Piirtoalusta(Tetris tetris) {
        this.tetris=tetris;
        super.setBackground(Color.BLACK);       
    }   

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }   
}
