package palikkapeli.grafiikka;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import palikkapeli.pelilogiikka.Tetris;


public class Nappaimistonkuuntelija implements KeyListener {
    private Tetris tetris;
    private Paivitettava paivitettava;

    Nappaimistonkuuntelija(Tetris tetris, Paivitettava paivitettava) {
        this.tetris=tetris;
        this.paivitettava=paivitettava;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            tetris.liikuVasemmalle();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            tetris.liikuOikealle();
        } else if (e.getKeyCode() == KeyEvent.VK_UP){
            tetris.kaanna();
        }
        paivitettava.paivita();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        tetris.liikuAlas();
    }
}
