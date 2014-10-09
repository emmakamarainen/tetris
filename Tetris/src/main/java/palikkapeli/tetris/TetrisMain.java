package palikkapeli.tetris;

import javax.swing.SwingUtilities;
import palikkapeli.grafiikka.Kayttoliittyma;
import palikkapeli.pelilogiikka.Tetris;

public class TetrisMain {

    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        Kayttoliittyma kayttis = new Kayttoliittyma(tetris);
        SwingUtilities.invokeLater(kayttis);
        while (kayttis.getPaivitettava() == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("asd");
            }
        }
        tetris.setPaivitettava(kayttis.getPaivitettava());
        tetris.kaynnista();
        
        
    }
}
