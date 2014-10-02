package palikkapeli.pelilogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import palikkapeli.grafiikka.Paivitettava;
import palikkapeli.objektit.Pala;
import palikkapeli.objektit.Palikka;
import palikkapeli.objektit.Pelilauta;
import palikkapeli.objektit.Tetrominot;

public class Tetris extends Timer implements ActionListener {

    private ArrayList<Palikka> pysahtyneet;
    private Palikka liikkuva;
    private Paivitettava paivitettava;
    private Pelilauta lauta;
    private boolean palaliikkuu;
    private boolean peliloppu;

    public Tetris() {
        super(1000, null);
        this.pysahtyneet = new ArrayList<Palikka>();
        this.liikkuva = new Palikka();
        this.lauta = new Pelilauta();
        this.palaliikkuu = false;
        this.peliloppu = false;
        addActionListener(this);
        setInitialDelay(1000);
    }

    /**
     * Käynnistää tetris-pelin
     */
    public void kaynnista() {
        this.start();
        while (!peliloppu) {
            uusiTetromino();
            liikuAlas();
//            try {
//                this.wait(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

    /**
     * Luo uuden Tetrominon ja asettaa sen liikkuvaksi.
     */
    public void uusiTetromino() {
        if (palaliikkuu == true) {
            return;
        }
        Tetrominot tetromino = new Tetrominot();
        SetLiikkuvaPalikka(tetromino.luoTetromino());
        palaliikkuu = true;
    }

    public void SetLiikkuvaPalikka(Palikka palikka) {
        this.liikkuva = palikka;
    }

//    /**
//     * Tarvitaanko?
//     */
//    public void asetaPalatLaudalle() {
//        for (Palikka palikka : pysahtyneet) {
//            for (Pala pala : palikka.getPalat()) {
//                lauta.asetaPalaRuutuun(pala.GetX(), pala.GetY());
//            }
//        }
//    }
//
//    /**
//     *
//     */
//    public void asetaLiikkuvatPalatLaudalle() {
//        for (Pala pala : liikkuva.getPalat()) {
//            lauta.asetaPalaRuutuun(pala.GetX(), pala.GetY());
//        }
//    }
    /**
     * Lisää ennen liikkuneen tetrominon pysähtyneeksi ja lisää sen listaan
     */
    public void liikkuvastaPalikastaPysahtynyt() {
        pysahtyneet.add(liikkuva);
        palaliikkuu = false;
    }

    /**
     * Muuttaa liikkuvan tetrominon palojen koordinaattia niin, että se liikkuu alaspäin. 
     */
    public void liikuAlas() {
        for (Pala pala : liikkuva.getPalat()) {

            if (lauta.onkoRuudussaPala(pala.GetX(), pala.GetY())) {
                liikkuvastaPalikastaPysahtynyt();
                return;
            }
            pala.SetXY(pala.GetX(), pala.GetY() + 1);
            System.out.println("liikuAlas");
        }
    }

    /**
     * Kääntää tetrominoa myötäpäivään
     */
    public void kaanna() {
        for (Pala pala : liikkuva.getPalat()) {
            pala.SetXY(pala.GetY(), pala.GetX() * (-1));
        }
    }

    /**
     * Liikuttaa tetrominoa oikealle
     */
    public void liikuOikealle() {
        for (Pala pala : liikkuva.getPalat()) {
            if (pala.GetX() == 9) {
                return;
            }
        }
        for (Pala pala : liikkuva.getPalat()) {
            pala.SetXY(pala.GetX() + 1, pala.GetY());
        }
    }

    /**
     * Liikuttaa tetrominoa vasemmalle
     */
    public void liikuVasemmalle() {
        for (Pala pala : liikkuva.getPalat()) {
            if (pala.GetX() == 0) {
                return;
            }
        }
        for (Pala pala : liikkuva.getPalat()) {
            pala.SetXY(pala.GetX() - 1, pala.GetY());
        }
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public ArrayList<Palikka> GetPysahtyneetTetriminot() {
        return pysahtyneet;
    }

    public Palikka GetLiikkuvaPalikka() {
        return liikkuva;
    }

    /**
     * Lopettaa pelin.
     */
    public void lopeta() {
        peliloppu = true;
        stop();
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