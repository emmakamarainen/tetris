package palikkapeli.palikat;

public class Pala {

    private final int pituus = 1;
    private final int leveys = 1;
    private int x;
    private int y;
    private Vari vari;

    public Pala(int x, int y, Vari vari) {
        this.x = x;
        this.y = y;
        this.vari = vari;
    }

    public void setXY(int dx, int dy) {
        this.x = dx;
        this.y = dy;
    }
}
