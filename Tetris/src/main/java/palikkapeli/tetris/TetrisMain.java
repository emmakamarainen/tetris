package palikkapeli.tetris;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import palikkapeli.grafiikka.Kayttoliittyma;
import palikkapeli.pelilogiikka.Tetris;

public class TetrisMain {

    public static void main(String[] args) {
//        Tetris tetris = new Tetris();
//        Kayttoliittyma kayttis =new Kayttoliittyma(tetris);
//        tetris.kaynnista();     
        
        JFrame frame = new JFrame("Palikkapeli");
        int leveys = 400;
        int korkeus = 500;
        frame.setSize(leveys, korkeus);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
       
        frame.setVisible(true);
        frame.pack();
    }
}
