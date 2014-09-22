package palikkapeli.palikat;

public class Pala {

    private final int pituus = 10;
    private final int leveys = 10;
    private int x;
    private int y;
    private Vari vari;

    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
        this.vari = vari;
    }

    public void SetXY(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }

    public void SetVari(Vari vari) {
        this.vari = vari;
    }

    public Vari GetVari() {
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
