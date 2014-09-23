package palikkapeli.grafiikka;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import palikkapeli.objektit.Pala;
import palikkapeli.objektit.Palikka;
import palikkapeli.pelilogiikka.Tetris;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Tetris tetris;

    public Piirtoalusta(Tetris tetris) {
        this.tetris = tetris;
        super.setBackground(Color.LIGHT_GRAY);
        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Palikka palikka : tetris.GetTetriminot()) {
            for (Pala pala : palikka.getPalat()) {
                g.drawRect(pala.GetX(), pala.GetY(), 10, 10);
                g.setColor(pala.GetVari());
                g.fillRect(pala.GetX(), pala.GetY(), 9, 9);
            }
        }
    }

    @Override
    public void paivita() {
        super.repaint();
    }
}
