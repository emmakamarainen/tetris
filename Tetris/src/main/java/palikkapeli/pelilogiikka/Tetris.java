package palikkapeli.pelilogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import palikkapeli.grafiikka.Paivitettava;
import palikkapeli.objektit.Pala;
import palikkapeli.objektit.Palikka;
import palikkapeli.objektit.Pelilauta;
import palikkapeli.objektit.Tetrominot;

public class Tetris extends Timer implements ActionListener {

    private ArrayList<Palikka> pysahtyneetpalikat;
    private Palikka liikkuvapalikka;
    private Paivitettava paivitettava;
    private Pelilauta lauta;
    private boolean palaliikkuu;
    private boolean peliloppu;

    public Tetris() {
        super(1000, null);
        this.pysahtyneetpalikat = new ArrayList<>();
        this.liikkuvapalikka = new Palikka();
        this.lauta = new Pelilauta();
        this.palaliikkuu = true;
        this.peliloppu = false;
    }

    public void kaynnista() {
    }

    public void uusiTetromino() {
        if (palaliikkuu == true) {
            return;
        }
        palaliikkuu = true;
        Tetrominot tetromino = new Tetrominot();
        SetLiikkuvaPalikka(tetromino.luoTetromino());
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
                palaliikkuu = false;
                return;
            }
            pala.SetXY(pala.GetX(), pala.GetY() - 1);
        }
    }

    public void kaanna() {
        for (Pala pala : liikkuvapalikka.getPalat()) {
            pala.SetXY(pala.GetY(), pala.GetX() * (-1));
        }
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

    public Palikka GetLiikkuvaPalikka() {
        return liikkuvapalikka;
    }

    public void lopeta() {
        peliloppu = true;
    }

    public int getPisteet() {
        int pisteet = lauta.GetRivit() * 100;
        return pisteet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (palaliikkuu) {
            liikuAlas();
            paivitettava.paivita();
        } else if (peliloppu) {
            paivitettava.paivita();
        }
    }
}
