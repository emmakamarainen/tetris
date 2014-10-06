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
        return palat.get(0).GetVari();
    }

    public void SetKoordinaatit(int[][] koordinaatit) {
        for (int i = 0; i < 4; i++) {
            palat.get(i).SetXY(koordinaatit[i][0], koordinaatit[i][1]);
        }
    }

    public void SetVari(Color vari) {
        for (Pala pala : palat) {
            pala.SetVari(vari);
        }
    }

    public boolean osuuPalikkaan(Palikka palikka) {
        for (Pala pala : palikka.getPalat()) {
            for (int i = 0; i < palat.size(); i++) {
                if (pala.PalaOsuu(palat.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
