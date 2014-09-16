package Grafiikka;

import Pelilogiikka.Tetris;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Nappaimistonkuuntelija implements KeyListener {
    private Tetris tetris;
    private Piirtoalusta piirtoalusta;

    Nappaimistonkuuntelija(Tetris tetris, Piirtoalusta alusta) {
        this.tetris=tetris;
        this.piirtoalusta=alusta;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            tetris.kaannaVasemmalle();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            tetris.kaannaOikealle();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
