package palikkapeli.tetris;

import palikkapeli.objektit.Pala;
import palikkapeli.objektit.Palikka;
import palikkapeli.pelilogiikka.Tetris;

public class TetrisMain {

    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        tetris.kaynnista();

        Palikka palikka = new Palikka();
        palikka.luoPalikanPalat();
        tetris.SetLiikkuvaPalikka(palikka);

        for (Pala pala : palikka.getPalat()) {
            System.out.println(pala);
        }
        int i=6;
        for (Pala pala : palikka.getPalat()) {
            
                pala.SetXY(i, i);
            i++;
        }
        for (Pala pala : palikka.getPalat()) {
            System.out.println(pala);
        }
//        Testailua
    }
}
