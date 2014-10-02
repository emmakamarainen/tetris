package palikkapeli.objektit;

import java.awt.Color;

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
     * @param dx    asetettava uusi x-arvo
     * @param dy    asetettava uusi y-arvo
     */
    public void SetXY(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    public void SetVari(Color vari) {
        this.vari = vari;
    }

    public Color GetVari() {
        return this.vari;
    }

    public int GetX() {
        return x;
    }

    public int GetY() {
        return y;
    }
    
    public int getPituus(){
        return this.pituus;
    }
    
    public int getLeveys(){
        return this.leveys;
    }
    
    /**
     * Testaa osuuko pala toiseen palaan.
     *
     * @param pala  Pala, minkä osumista testataan
     * @return
     */
    public boolean PalaOsuu(Pala pala) {
        if (this.x == pala.GetX()) {
            if (this.y == pala.GetY()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
