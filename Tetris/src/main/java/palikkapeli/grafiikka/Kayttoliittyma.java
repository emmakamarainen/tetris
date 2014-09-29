package palikkapeli.grafiikka;

import java.awt.BorderLayout;
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
        container.add(tetrisAlusta, BorderLayout.CENTER);
        frame.addKeyListener(new Nappaimistonkuuntelija(tetris, piirtoalusta));
    }

    @Override
    public void run() {
        frame = new JFrame("Palikkapeli");
        int leveys = 600;
        int korkeus = 700;
        frame.setPreferredSize(new Dimension(leveys,korkeus));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setUndecorated(true);
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
