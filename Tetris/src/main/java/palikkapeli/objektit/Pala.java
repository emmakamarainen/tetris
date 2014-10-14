package palikkapeli.objektit;

import java.awt.Color;

/**
 * Yksittäisen palan luokka, paloista muodostetaan tetrominoja.
 *
 * @author Emma
 */
public class Pala {

    private final int pituus = 30;
    private final int leveys = 30;
    private int x;
    private int y;
    private Color vari;

    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Laittaa palalle tietyt x- ja y- koordinaatit.
     *
     * @param dx asetettava uusi x-arvo
     * @param dy asetettava uusi y-arvo
     */
    public void setXY(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    public void setVari(Color vari) {
        this.vari = vari;
    }

    public Color getVari() {
        return this.vari;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPituus() {
        return this.pituus;
    }

    public int getLeveys() {
        return this.leveys;
    }

    /**
     * Testaa osuuko pala toiseen palaan.
     *
     * @param pala Pala, minkä osumista testataan
     * @return
     */
    public boolean palaOsuu(Pala pala) {
        if (this.x == pala.getX() && this.y == pala.getY()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
