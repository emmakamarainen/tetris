package palikkapeli.pelilogiikka;

import java.util.ArrayList;
import palikkapeli.grafiikka.Kayttoliittyma;
import palikkapeli.grafiikka.Paivitettava;
import palikkapeli.objektit.Pala;
import palikkapeli.objektit.Palikka;
import palikkapeli.objektit.Pelilauta;

public class Tetris {

    private ArrayList<Palikka> palikkalista;
    private Paivitettava paivitettava;
    private Pelilauta lauta;

    public Tetris() {
        palikkalista = new ArrayList<>();
    }

    public void kaynnista() {
        lauta = new Pelilauta();
    }
    
    public void asetaPalatLaudalle(){
        for (Palikka palikka: palikkalista){
            for(Pala pala: palikka.getPalat()){
                lauta.asetaPalaRuutuun(pala.GetX(), pala.GetY());
            }
        }
    }

    public void kaannaOikealle() {
    }

    public void kaannaVasemmalle() {
    }

    public void liikuOikealle() {
    }

    public void liikuVasemmalle() {
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }
    
    public ArrayList<Palikka> GetTetriminot(){
        return palikkalista;
    }
}
