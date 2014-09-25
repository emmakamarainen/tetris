package palikkapeli.pelilogiikka;

import java.util.ArrayList;
import palikkapeli.grafiikka.Paivitettava;
import palikkapeli.objektit.Pala;
import palikkapeli.objektit.Palikka;
import palikkapeli.objektit.Pelilauta;

public class Tetris {

    private ArrayList<Palikka> pysahtyneetpalikat;
    private Palikka liikkuvapalikka;
    private Paivitettava paivitettava;
    private Pelilauta lauta;

    public Tetris() {
        pysahtyneetpalikat = new ArrayList<>();
        liikkuvapalikka = new Palikka();
        lauta = new Pelilauta();
    }

    public void kaynnista() {
    }

    public void SetLiikkuvaPalikka(Palikka palikka) {
        this.liikkuvapalikka = palikka;
    }

    public void asetaPalatLaudalle() {
        for (Palikka palikka : pysahtyneetpalikat) {
            for (Pala pala : palikka.getPalat()) {
                lauta.asetaPalaRuutuun(pala.GetX(), pala.GetY());
            }
        }
    }

    public void liikkuvastaPalikastaPysahtynyt() {
        pysahtyneetpalikat.add(liikkuvapalikka);
    }

    public void liikuAlas() {
        for (Pala pala : liikkuvapalikka.getPalat()) {
            if (lauta.onkoRuudussaPala(pala.GetX(), pala.GetY())) {
                liikkuvastaPalikastaPysahtynyt();
                return;
            }
            pala.SetXY(pala.GetX(), pala.GetY() - 1);
        }
    }

    public void kaanna() {
    }

    public void liikuOikealle() {
        for (Pala pala : liikkuvapalikka.getPalat()) {
            if (pala.GetX() == 9) {
                return;
            }
        }
        for (Pala pala : liikkuvapalikka.getPalat()) {
            pala.SetXY(pala.GetX() + 1, pala.GetY());
        }
    }

    public void liikuVasemmalle() {
        for (Pala pala : liikkuvapalikka.getPalat()) {
            if (pala.GetX() == 0) {
                return;
            }
        }
        for (Pala pala : liikkuvapalikka.getPalat()) {
            pala.SetXY(pala.GetX() - 1, pala.GetY());
        }
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public ArrayList<Palikka> GetPysahtyneetTetriminot() {
        return pysahtyneetpalikat;
    }

    public Palikka GetLiikkuvaTetrimino() {
        return liikkuvapalikka;
    }
}
