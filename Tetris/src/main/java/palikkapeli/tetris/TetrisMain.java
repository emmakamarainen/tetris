package palikkapeli.tetris;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import palikkapeli.grafiikka.Kayttoliittyma;
import palikkapeli.pelilogiikka.Tetris;

public class TetrisMain {

    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        Kayttoliittyma kayttis =new Kayttoliittyma(tetris);
        kayttis.run();
        tetris.kaynnista();     
        
        
    }
}
