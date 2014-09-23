package palikkapeli.objektit;

import java.util.ArrayList;

public class Palikka {
    
    /**
     * Tässä luokassa luodaan lista, jossa on yhden tetrispalikan palat.
     */

    private ArrayList<Pala> palat;

    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }
    
    /**
     * Palojen luontimetodi, palat eivät ole lopullisilla paikoillaan.
     */
    
    public void luoPalikanPalat(){
        for (int i=0; i==4;i++){
            Pala pala = new Pala(0,0);
            lisaaPala(pala);
        }
    }       

    public ArrayList<Pala> getPalat() {
        return this.palat;
    }
}
