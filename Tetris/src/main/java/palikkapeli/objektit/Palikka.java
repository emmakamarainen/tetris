package palikkapeli.objektit;

import java.util.ArrayList;

public class Palikka {

    /**
     * Tässä luokassa luodaan lista, jossa on yhden tetrispalikan palat.
     */
    private ArrayList<Pala> palat;

    public Palikka() {
        palat = new ArrayList<>();
    }

    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }

    /**
     * Palojen luontimetodi, palat eivät ole lopullisilla paikoillaan.
     */
    public void luoPalikanPalat() {
        for (int i = 1; i < 5; i++) {
            Pala pala = new Pala(i, i);
            lisaaPala(pala);
        }
    }

    public ArrayList<Pala> getPalat() {
        return this.palat;
    }

    
}
