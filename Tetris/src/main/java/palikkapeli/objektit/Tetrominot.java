package palikkapeli.objektit;

import java.awt.Color;
import java.util.Random;

public class Tetrominot {

    private final int[][][] koordinaatit;
    private final Color[] varit;
    private Random random;

    public Tetrominot() {
        koordinaatit = new int[][][]{
            //            {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
            {{0, 0}, {1, 0}, {-2, 0}, {-1, 0}}, // I
            {{0, 0}, {1, 0}, {1, 1}, {-1, 0}}, // J
            {{0, 0}, {1, 0}, {-1, 1}, {-1, 0}}, // L
            {{0, 0}, {-1, 1}, {0, 1}, {-1, 0}}, // O
            {{0, 0}, {1, 0}, {-1, 1}, {0, 1}}, // S
            {{0, 0}, {1, 0}, {0, 1}, {-1, 0}}, // T
            {{0, 0}, {0, 1}, {1, 1}, {-1, 0}} // Z
        };
        varit = new Color[]{Color.GREEN, Color.RED, Color.PINK, Color.YELLOW, Color.BLUE, Color.CYAN, Color.DARK_GRAY};
        random = new Random();
    }

    /**
     * Metodi järjestää Palikan palat koordinaattien mukaan, luotava tetrimino
     * arpoutuu. Metodi myös lisää värin palalle.
     * @return 
     */
    public Palikka luoTetromino() {
        Palikka palikka = new Palikka();
        palikka.luoPalikanPalat();
        int i = mikaPalikka();
        for (int j = 0; j < koordinaatit[i].length; j++) {
            for (Pala pala : palikka.getPalat()) {
                pala.SetXY(koordinaatit[i][j][0], koordinaatit[i][j][1]);
                pala.SetVari(varit[i]);
            }
        }
        return palikka;
    }

    /**
     * Arpoo numeron, jota hyödynnetään tetriminon luonnissa.
     *
     * @return
     */
    public int mikaPalikka() {
        return random.nextInt(7);
    }       
}
