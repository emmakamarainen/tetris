package palikkapeli.objektit;

import java.awt.Color;

public class Pala {

    private final int pituus = 10;
    private final int leveys = 10;
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
     * @param dx
     * @param dy
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

    /**
     * Testaa osuuko pala toiseen palaan.
     * @param pala
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
}
