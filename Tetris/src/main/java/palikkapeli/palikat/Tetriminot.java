package palikkapeli.palikat;

import java.util.Random;

public class Tetriminot {

    private int[][][] koordinaatit;
    private Vari[] varit;
    private Random random;

    public Tetriminot() {
        koordinaatit = new int[][][]{
            //            {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
            {{-2, 0}, {-1, 0}, {0, 0}, {1, 0}}, // I
            {{-1, 0}, {0, 0}, {1, 0}, {1, 1}}, // J
            {{-1, 0}, {0, 0}, {1, 0}, {-1, 1}}, // L
            {{-1, 0}, {0, 0}, {-1, 1}, {0, 1}}, // O
            {{0, 0}, {1, 0}, {-1, 1}, {0, 1}}, // S
            {{-1, 0}, {0, 0}, {1, 0}, {0, 1}}, // T
            {{-1, 0}, {0, 0}, {0, 1}, {1, 1}} // Z
        };
        varit = new Vari[]{Vari.GREEN, Vari.RED, Vari.PINK, Vari.YELLOW, Vari.BLUE, Vari.CYAN, Vari.GREY};
        random = new Random();
    }

    /**
     * Metodi järjestää Palikan palat koordinaattien mukaan, luotava tetrimino
     * arpoutuu. Metodi myös lisää värin palalle.
     */
    public void luoTetrimino() {
        Palikka palikka = new Palikka();
        palikka.luoPalikanPalat();
        int i = mikaPalikka();
        for (int j = 0; j < koordinaatit[i].length; j++) {
            for (Pala pala : palikka.getPalat()) {
                pala.SetXY(koordinaatit[i][j][0], koordinaatit[i][j][1]);
                pala.SetVari(varit[i]);
            }
        }
    }
/**
 * Arpoo numeron, jota hyödynnetään tetriminon luonnissa. 
 * @return 
 */
    public int mikaPalikka() {
        return random.nextInt(7);
    }
}
