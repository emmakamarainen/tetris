package palikkapeli.objektit;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Tetrikssä luotava palikka, joka koostuu paloista.
 *
 * Tässä luokassa luodaan lista, jossa on yhden tetrispalikan palat. Niille
 * laitetaan oikeat koordinaatit Tetromino-luokassa.
 *
 * @author Emma
 */
public class Palikka {

    private ArrayList<Pala> palat;

    public Palikka() {
        palat = new ArrayList<>();
    }

    /**
     * Metodi lisää parametrina annetun palan Palikan palalistaan
     *
     * @param pala pala, joka lisätään
     */
    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }

    /**
     * Palojen luontimetodi, palat eivät ole lopullisilla paikoillaan.
     *
     * @see luoTetromino() asettaa oikeat koordinaatit
     */
    public void luoPalikanPalat() {
        for (int i = 1; i < 5; i++) {
            Pala pala = new Pala(1, i);
            lisaaPala(pala);
        }
    }

    public ArrayList<Pala> getPalat() {
        return this.palat;
    }

    public Color GetVari() {
        return palat.get(0).getVari();
    }
}
