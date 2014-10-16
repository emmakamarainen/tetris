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

/**
 * Tetriksen pyörittämiseen tarvittavat metodit ovat tässä luokassa.
 *
 * @author Emma
 */
public class Tetris extends Timer implements ActionListener {

    private ArrayList<Pala> pysahtyneet;
    private Palikka liikkuva;
    private Paivitettava paivitettava;
    private Pelilauta lauta;
    private boolean palaliikkuu;
    private boolean peliloppu;
    private int nopeus;

    public Tetris() {
        super(700, null);
        this.pysahtyneet = new ArrayList<>();
        this.liikkuva = new Palikka();
        this.lauta = new Pelilauta();
        this.palaliikkuu = false;
        this.peliloppu = false;
        this.nopeus = 700;
        addActionListener(this);
        setInitialDelay(700);
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
                return;
            }
        }
        for (Pala pala : liikkuva.getPalat()) {
            pala.setXY(pala.getX(), pala.getY() + 1);
        }
    }

    /**
     * Muuttaa liikkuvan tetrominon palojen koordinaattia niin, että se kääntyy
     * myötäpäivään.
     */
    public void kaanna() {
        if (!liikkuva.getPalat().isEmpty()) {
            for (Pala pala : liikkuva.getPalat()) {
                int x = liikkuva.getPalat().get(0).getX();
                int y = liikkuva.getPalat().get(0).getY();
                if (lauta.onkoRuudussaPala((pala.getY() - y) + x, ((pala.getX() - x) * (-1)) + y)) {
                    return;
                }
            }
            for (Pala pala : liikkuva.getPalat()) {
                int x = liikkuva.getPalat().get(0).getX();
                int y = liikkuva.getPalat().get(0).getY();
                pala.setXY((pala.getY() - y) + x, ((pala.getX() - x) * (-1)) + y);
            }
        }
    }

    /**
     * Liikuttaa tetrominoa oikealle.
     */
    public void liikuOikealle() {
        if (!liikkuva.getPalat().isEmpty()) {
            for (Pala pala : liikkuva.getPalat()) {
                if (lauta.onkoRuudussaPala(pala.getX() + 1, pala.getY())) {
                    return;
                }
            }
            for (Pala pala : liikkuva.getPalat()) {
                pala.setXY(pala.getX() + 1, pala.getY());
            }
        }
    }

    /**
     * Liikuttaa tetrominoa vasemmalle.
     */
    public void liikuVasemmalle() {
        if (!liikkuva.getPalat().isEmpty()) {
            for (Pala pala : liikkuva.getPalat()) {
                if (lauta.onkoRuudussaPala(pala.getX() - 1, pala.getY())) {
                    return;
                }
            }
            for (Pala pala : liikkuva.getPalat()) {
                pala.setXY(pala.getX() - 1, pala.getY());
            }
        }
    }

    /**
     * Lopettaa pelin.
     */
    public void lopeta() {
        this.peliloppu = true;
        stop();
    }

    /**
     * Aloittaa pelin alusta.
     */
    public void aloitaAlusta() {
        this.peliloppu = false;
        this.liikkuva.getPalat().clear();
        this.pysahtyneet.clear();
        this.lauta.nollaaLauta();
        kaynnista();
    }

    /**
     * Tarkistaa, meneekö tetromino yläreunan yli.
     */
    public void osuuYlareunaan() {
        for (int i = 0; i < liikkuva.getPalat().size(); i++) {
            if (lauta.onkoRuudussaPala(liikkuva.getPalat().get(i).getX(), liikkuva.getPalat().get(i).getY())) {
                lopeta();
            }
        }
    }

    /**
     * Selvittää laudalta täydet rivit ja poistaa ne.
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
            kasvataNopeutta();
            paivitettava.paivita();
        }
    }

    /**
     * Etsii pysähtyneistä paloista oikealla korkuudella olevat palat ja lisää
     * ne listaan.
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
        if (rivinro > 0 || rivinro < 20) {
            for (Pala pala : pysahtyneet) {
                if (pala.getY() < rivinro) {
                    pala.setXY(pala.getX(), pala.getY() + 1);
                }
            }
        }
    }

    /**
     * Kasvattaa tetrominojen putoamisnopeutta.
     */
    public void kasvataNopeutta() {
        if (this.nopeus >= 150) {
            this.nopeus -= 50;
            setDelay(this.nopeus);
        }
    }

    public int getNopeus() {
        return nopeus;
    }

    public void setNopeus(int uusinopeus) {
        this.nopeus = uusinopeus;
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

    public Palikka getLiikkuva() {
        return liikkuva;
    }

    public boolean getPeliloppu() {
        return peliloppu;
    }

    public boolean getPalaLiikkuu() {
        return palaliikkuu;
    }

    public Pelilauta getPelilauta() {
        return lauta;
    }

    public int getPisteet() {
        return lauta.GetRivit() * 100;
    }

    /**
     * Kasvattaa pisteitä sadalla.
     *
     * @return pisteet palauttaa kasvaneen pistemäärän
     */
    public void kasvataPisteitä() {
        lauta.lisaaRivi();
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
