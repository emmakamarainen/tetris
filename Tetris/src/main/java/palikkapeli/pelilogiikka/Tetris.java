package palikkapeli.pelilogiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import palikkapeli.grafiikka.Paivitettava;
import palikkapeli.objektit.Pala;
import palikkapeli.objektit.Palikka;
import palikkapeli.objektit.Pelilauta;
import palikkapeli.objektit.Tetromino;

public class Tetris extends Timer implements ActionListener {

    private ArrayList<Palikka> pysahtyneet;
    private Palikka liikkuva;
    private Paivitettava paivitettava;
    private Pelilauta lauta;
    private boolean palaliikkuu;
    private boolean peliloppu;  

    public Tetris() {
        super(500, null);
        this.pysahtyneet = new ArrayList<>();
        this.liikkuva = new Palikka();
        this.lauta = new Pelilauta();
        this.palaliikkuu = false;
        this.peliloppu = false;
        addActionListener(this);
        setInitialDelay(500);
    }

    /**
     * Käynnistää tetris-pelin
     */
    public void kaynnista() {
        this.start();
        while (!peliloppu) {
            osuuYlareunaan();
            uusiTetromino();

        }
    }

    /**
     * Luo uuden Tetrominon ja asettaa sen liikkuvaksi.
     */
    public void uusiTetromino() {
        if (palaliikkuu == true) {
            return;
        }
        Tetromino tetromino = new Tetromino();
        SetLiikkuvaPalikka(tetromino.luoTetromino());
        asetaPalatLaudalle();
        palaliikkuu = true;
    }

    public void SetLiikkuvaPalikka(Palikka palikka) {
        this.liikkuva = palikka;
    }

    public void asetaPalatLaudalle() {
        lauta.nollaaLauta();
        asetaPysahtyneetPalatLaudalle();
    }

    /**
     * Tarvitaanko?
     */
    public void asetaPysahtyneetPalatLaudalle() {
        if (!pysahtyneet.isEmpty()) {
            for (Palikka palikka : pysahtyneet) {
                for (Pala pala : palikka.getPalat()) {
                    lauta.asetaPalaRuutuun(pala.GetX(), pala.GetY());
                }
            }
        }
    }

    /**
     * Lisää ennen liikkuneen tetrominon pysähtyneeksi ja lisää sen listaan
     */
    public void liikkuvastaPalikastaPysahtynyt() {
        pysahtyneet.add(liikkuva);
        palaliikkuu = false;
    }

    /**
     * Muuttaa liikkuvan tetrominon palojen koordinaattia niin, että se liikkuu
     * alaspäin.
     */
    public void liikuAlas() {
        for (Pala pala : liikkuva.getPalat()) {
            if (lauta.onkoRuudussaPala(pala.GetX(), pala.GetY() + 1)) {
                liikkuvastaPalikastaPysahtynyt();
//                System.out.println("liikuAlas ruudussa pala");
                return;
            }
        }
        for (Pala pala : liikkuva.getPalat()) {
            pala.SetXY(pala.GetX(), pala.GetY() + 1);
//            System.out.println("liikuAlas");
        }
    }

    /**
     * Kääntää tetrominoa myötäpäivään
     */
    public void kaanna() {
        for (Pala pala : liikkuva.getPalat()) {
            if (lauta.onkoRuudussaPala(pala.GetY(), pala.GetX() * (-1))) {
                System.out.println("kääntyy reunojen yli");
                return;
            }
        }
        for (Pala pala : liikkuva.getPalat()) {
            pala.SetXY(pala.GetY(), pala.GetX() * (-1));
            System.out.println("kaanna");
        }
    }

    /**
     * Liikuttaa tetrominoa oikealle
     */
    public void liikuOikealle() {
        for (Pala pala : liikkuva.getPalat()) {
            if (lauta.onkoRuudussaPala(pala.GetX() + 1, pala.GetY())) {
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
            if (lauta.onkoRuudussaPala(pala.GetX() - 1, pala.GetY())) {
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

    public Paivitettava GetPaivitettava() {
        return paivitettava;
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

    public void osuuYlareunaan() {
        for (Pala pala : liikkuva.getPalat()) {
            if (lauta.onkoRuudussaPala(pala.GetX(), pala.GetY())) {
                lopeta();
            }
//            for (Palikka palikka : pysahtyneet) {
//                for (Pala pyspala : palikka.getPalat()) {
//                    if (pala.PalaOsuu(pyspala)) {
//                        lopeta();
//                    }
//                }
//            }
        }
    }

    public boolean GetPeliloppu() {
        return peliloppu;
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
