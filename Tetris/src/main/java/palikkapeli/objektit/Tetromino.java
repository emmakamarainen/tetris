package palikkapeli.objektit;

import java.awt.Color;
import java.util.Random;

public class Tetromino {

    private final int[][][] koordinaatit;
    private final Color[] varit;
    private Random random;

    public Tetromino() {
        koordinaatit = new int[][][]{
            {{5, 0}, {6, 0}, {3, 0}, {4, 0}}, // I
            {{5, 0}, {6, 0}, {6, 1}, {4, 0}}, // J
            {{5, 0}, {6, 0}, {4, 1}, {4, 0}}, // L
            {{5, 0}, {4, 1}, {5, 1}, {4, 0}}, // O
            {{5, 0}, {6, 0}, {4, 1}, {5, 1}}, // S
            {{5, 0}, {6, 0}, {5, 1}, {4, 0}}, // T
            {{5, 0}, {0, 1}, {6, 1}, {4, 0}} // Z
            
//            {{0, 0}, {1, 0}, {-2, 0}, {-1, 0}}, // I
//            {{0, 0}, {1, 0}, {1, 1}, {-1, 0}}, // J
//            {{0, 0}, {1, 0}, {-1, 1}, {-1, 0}}, // L
//            {{0, 0}, {-1, 1}, {0, 1}, {-1, 0}}, // O
//            {{0, 0}, {1, 0}, {-1, 1}, {0, 1}}, // S
//            {{0, 0}, {1, 0}, {0, 1}, {-1, 0}}, // T
//            {{0, 0}, {0, 1}, {1, 1}, {-1, 0}} // Z
        };
        varit = new Color[]{Color.GREEN, Color.RED, Color.PINK, Color.YELLOW, Color.BLUE, Color.CYAN, Color.DARK_GRAY};
        random = new Random();
    }

    /**
     * Metodi järjestää Palikan palat koordinaattien mukaan, luotava tetrimino
     * arpoutuu. Metodi myös lisää värin palalle.
     *
     * @return palauttaa palikan, jolla on oikeat koordinaatit
     */
    public Palikka luoTetromino() {
        Palikka palikka = new Palikka();
        palikka.luoPalikanPalat();
        int i = mikaPalikka();
        for (int j = 0; j < koordinaatit[i].length; j++) {
            Pala pala = palikka.getPalat().get(j);
            pala.SetXY(koordinaatit[i][j][0], koordinaatit[i][j][1]);
            pala.SetVari(varit[i]);
        }
        return palikka;
    }

    /**
     * Metodi järjestää Palikan palat annetun parametrin koordinaattien mukaan.  
     * Metodi myös lisää värin palalle.
     * @param i riviluku, jonka avulla haetaan halutut koordinaatit taulukosta
     * @return palauttaa palikan, jolla on oikeat koordinaatit
     */
    public Palikka luoTetromino(int i) {
        Palikka palikka = new Palikka();
        palikka.luoPalikanPalat();
        for (int j = 0; j < koordinaatit[i].length; j++) {
            Pala pala = palikka.getPalat().get(j);
            pala.SetXY(koordinaatit[i][j][0], koordinaatit[i][j][1]);
            pala.SetVari(varit[i]);
        }
        return palikka;
    }

    /**
     * Arpoo numeron, jota hyödynnetään tetriminon luonnissa.
     *
     * @return palauttaa arvotun numeron väliltä 0-7
     */
    public int mikaPalikka() {
        return random.nextInt(7);
    }

    public Color getVari(int i) {
        return varit[i];
    }

    public int[][] getKoordinaatit(int i) {
        return koordinaatit[i];
    }
}