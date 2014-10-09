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

    private ArrayList<Pala> pysahtyneet;
    private Palikka liikkuva;
    private Paivitettava paivitettava;
    private Pelilauta lauta;
    private boolean palaliikkuu;
    private boolean peliloppu;

    public Tetris() {
        super(200, null);
        this.pysahtyneet = new ArrayList<>();
        this.liikkuva = new Palikka();
        this.lauta = new Pelilauta();
        this.palaliikkuu = false;
        this.peliloppu = false;
        addActionListener(this);
        setInitialDelay(200);
    }

    /**
     * Käynnistää tetris-pelin
     */
    public void kaynnista() {
        this.start();
        while (!peliloppu) {

            osuuYlareunaan();
            uusiTetromino();
            poistaTaydetRivit();
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
        setLiikkuvaPalikka(tetromino.luoTetromino());
        asetaPalatLaudalle();
        palaliikkuu = true;
    }

    public void setLiikkuvaPalikka(Palikka palikka) {
        this.liikkuva = palikka;
    }

    /**
     * Kierroksen alussa ensin nollaa laudan, jotta mahdollisesti poistuneet
     * palat poistuvat. Sen jälkeen asettaa yksittäiset palat pelilaudalle,
     * jotta pelilauta tunnistaa missä ruudussa on pala ja missä ei.
     */
    public void asetaPalatLaudalle() {
        lauta.nollaaLauta();
        if (!pysahtyneet.isEmpty()) {
            for (Pala pala : pysahtyneet) {
                lauta.asetaPalaRuutuun(pala.getX(), pala.getY());
            }
        }
    }

    /**
     * Laittaa ennen liikkuneen tetrominon pysähtyneeksi ja lisää sen palat
     * pysähtyneiden palojen listaan.
     */
    public void liikkuvastaPalikastaPysahtynyt() {
        for (Pala pala : liikkuva.getPalat()) {
            pysahtyneet.add(pala);
        }
        palaliikkuu = false;
    }

    /**
     * Muuttaa liikkuvan tetrominon palojen koordinaattia niin, että se liikkuu
     * alaspäin.
     */
    public void liikuAlas() {
        for (Pala pala : liikkuva.getPalat()) {
            if (lauta.onkoRuudussaPala(pala.getX(), pala.getY() + 1)) {
                liikkuvastaPalikastaPysahtynyt();
//                System.out.println("liikuAlas ruudussa pala");
                return;
            }
        }
        for (Pala pala : liikkuva.getPalat()) {
            pala.setXY(pala.getX(), pala.getY() + 1);
//            System.out.println("liikuAlas");
        }
    }

    /**
     * Muuttaa liikkuvan tetrominon palojen koordinaattia niin, että se kääntyy
     * myötäpäivään.
     */
    public void kaanna() {
        for (Pala pala : liikkuva.getPalat()) {
            int x = liikkuva.getPalat().get(0).getX();
            int y = liikkuva.getPalat().get(0).getY();
            int uusix = (pala.getY() - y) + x;
            int uusiy = ((pala.getX() - x) * (-1)) + y;
            if (lauta.onkoRuudussaPala(uusix, uusiy)) {
                return;
            }
        }
        for (Pala pala : liikkuva.getPalat()) {
            int x = liikkuva.getPalat().get(0).getX();
            int y = liikkuva.getPalat().get(0).getY();
            int uusix = (pala.getY() - y) + x;
            int uusiy = ((pala.getX() - x) * (-1)) + y;
            pala.setXY(uusix, uusiy);
        }
    }

    /**
     * Liikuttaa tetrominoa oikealle.
     */
    public void liikuOikealle() {
        for (Pala pala : liikkuva.getPalat()) {
            if (lauta.onkoRuudussaPala(pala.getX() + 1, pala.getY())) {
                return;
            }
        }
        for (Pala pala : liikkuva.getPalat()) {
            pala.setXY(pala.getX() + 1, pala.getY());
        }
    }

    /**
     * Liikuttaa tetrominoa vasemmalle.
     */
    public void liikuVasemmalle() {
        for (Pala pala : liikkuva.getPalat()) {
            if (lauta.onkoRuudussaPala(pala.getX() - 1, pala.getY())) {
                return;
            }
        }
        for (Pala pala : liikkuva.getPalat()) {
            pala.setXY(pala.getX() - 1, pala.getY());
        }
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public Paivitettava getPaivitettava() {
        return paivitettava;
    }

    public ArrayList<Pala> getPysahtyneet() {
        return pysahtyneet;
    }

    public Palikka getLiikkuvaPalikka() {
        return liikkuva;
    }

    /**
     * Lopettaa pelin.
     */
    public void lopeta() {
        peliloppu = true;
        stop();
    }

    /**
     * Tarkistaa, meneekö tetromino yläreunan yli.
     */
    public void osuuYlareunaan() {
        for (Pala pala : liikkuva.getPalat()) {
            if (lauta.onkoRuudussaPala(pala.getX(), pala.getY())) {
                lopeta();
            }
        }
    }

    /**
     *
     * @param p
     */
    public void poistaPysahtynytPala(Pala p) {
        for (int i = pysahtyneet.size() - 1; i > 0; i--) {
            if (p.getX() == pysahtyneet.get(i).getX() && p.getY() == pysahtyneet.get(i).getY()) {
                pysahtyneet.remove(pysahtyneet.get(i));
            }
        }
    }

    /**
     *
     */
    public void poistaTaydetRivit() {
        ArrayList<Integer> rivinrot = new ArrayList<>();
        if (!lauta.taysienRivienLista().isEmpty()) {
            for (int rivi : lauta.taysienRivienLista()) {
                poistaRivi(rivi);
                lauta.poistaRivi(rivi);
                rivinrot.add(rivi);
            }
            for (int i : rivinrot) {
                yksiRiviAlaspain(i);
            }
            asetaPalatLaudalle();
            paivitettava.paivita();
        }
    }
    
    /**
     * Etsii pysähtyneistä paloista oikealla korkuudella olevat palat ja lisää ne listaan.
     * 
     * @param Y annetaan poistettavien palojen y-koordinaatti
     * @return palauttaa listan poistettavista paloista
     */

    public ArrayList<Pala> etsiPoistettavatPalat(int Y) {
        ArrayList<Pala> lista = new ArrayList<>();
        for (Pala pala : pysahtyneet) {
            if (pala.getY() == Y) {
                lista.add(pala);
            }
        }
        return lista;
    }

    /**
     * Poistaa y-koordinaatin mukaan yhden rivin pysahtyneistä paloista. 
     *
     * @param Y haluttu rivi(korkeus)
     */
    public void poistaRivi(int Y) {
        for (Pala pala : etsiPoistettavatPalat(Y)) {
            pysahtyneet.remove(pala);
        }
    }

    /**
     * Siirtää paloja, jotka ovat annetun rivinumeron yläpuolella yhden rivin
     * alaspäin.
     *
     * @param rivinro
     */
    public void yksiRiviAlaspain(int rivinro) {
        for (Pala pala : pysahtyneet) {
            if (pala.getY() < rivinro) {
                pala.setXY(pala.getX(), pala.getY() + 1);
            }
        }
    }

    public boolean getPeliloppu() {
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
