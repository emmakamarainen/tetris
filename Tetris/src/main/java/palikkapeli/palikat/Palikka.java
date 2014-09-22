package palikkapeli.palikat;

import java.util.ArrayList;

public class Palikka {

    private ArrayList<Pala> palat;

    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }
    
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
