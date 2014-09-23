package palikkapeli.grafiikka;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import palikkapeli.pelilogiikka.Tetris;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Piirtoalusta piirtoalusta;
    private Tetris tetris;

    public Kayttoliittyma(Tetris tetris) {
        this.tetris = tetris;
    }

    public void luoKomponentit(Container container) {
        Piirtoalusta tetrisAlusta = new Piirtoalusta(this.tetris);
        this.piirtoalusta = tetrisAlusta;
        container.add(tetrisAlusta);
        frame.addKeyListener(new Nappaimistonkuuntelija(tetris, piirtoalusta));
    }

    @Override
    public void run() {
        frame = new JFrame("Palikkapeli");
        int leveys = 500;
        int korkeus = 600;
        frame.setPreferredSize(new Dimension(leveys,korkeus));
//        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        luoKomponentit(frame.getContentPane());
        frame.setVisible(true);
        frame.pack();
    }

    public Frame getFrame() {
        return frame;
    }

    public Paivitettava getPaivitettava() {
        return piirtoalusta;
    }
}
