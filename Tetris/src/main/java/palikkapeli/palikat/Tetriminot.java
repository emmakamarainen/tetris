package palikkapeli.palikat;

import java.util.Random;

public class Tetriminot {

    private int[][][] koordinaatit;
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
        random = new Random();
    }

    public void luoTetrimino() {
        Palikka palikka=new Palikka();
        palikka.luoPalikanPalat();
        int i = mikaPalikka();
        for (int j=0 ; j < koordinaatit[i].length; j++) {   
                for(int k=0; k< koordinaatit[i][j].length; k++) {  
                     for( Pala pala: palikka.getPalat()){
//                         pala.SetXY(koordinaatit[i][j]);
                     }
                }   
            }   
        
    }
    
    public int mikaPalikka(){
        return random.nextInt(7);
    }
}
