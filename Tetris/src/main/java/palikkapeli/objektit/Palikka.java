package palikkapeli.objektit;

import java.awt.Color;
import java.util.ArrayList;

public class Palikka {

    /**
     * Tässä luokassa luodaan lista, jossa on yhden tetrispalikan palat.
     */
    private ArrayList<Pala> palat;

    public Palikka() {
        palat = new ArrayList<>();
    }

    /**
     * Metodi lisää palikoita Palikan palalistaan
     * @param pala  pala, joka lisätään 
     */
    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }

    /**
     * Palojen luontimetodi, palat eivät ole lopullisilla paikoillaan.
     * @see luoTetromino()  asettaa oikeat koordinaatit
     */
    public void luoPalikanPalat() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Pala luotu");
            Pala pala = new Pala(1, i);
            lisaaPala(pala);
        }
    }

    public ArrayList<Pala> getPalat() {
        return this.palat;
    }

    public Color GetVari() {
        return palat.get(0).GetVari();
    }
}