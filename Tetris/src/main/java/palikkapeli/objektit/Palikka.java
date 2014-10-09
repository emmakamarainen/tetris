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
     * Metodi lisää parametrina annetun palan Palikan palalistaan
     *
     * @param pala pala, joka lisätään
     */
    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }
    
//    /**
//     * Metodi poistaa parametrina annetun palan palikasta.
//     * @param pala 
//     */
//    public void poistaPala(Pala p){
//        System.out.println(palat.size());
//       for (int i = 0; i < 4; i++) {
//           if (palat.get(i).GetX()==p.GetX() && palat.get(i).GetY()==p.GetY()){
//              palat.remove(i);
//           }
//       }
//        
//    }

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

    public void SetKoordinaatit(int[][] koordinaatit) {
        for (int i = 0; i < 4; i++) {
            palat.get(i).setXY(koordinaatit[i][0], koordinaatit[i][1]);
        }
    }

    public void SetVari(Color vari) {
        for (Pala pala : palat) {
            pala.setVari(vari);
        }
    }

    public boolean osuuPalikkaan(Palikka palikka) {
        for (Pala pala : palikka.getPalat()) {
            for (int i = 0; i < palat.size(); i++) {
                if (pala.palaOsuu(palat.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
