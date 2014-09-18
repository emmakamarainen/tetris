
package palikkapeli.palikat;

public class ZPalikka {

    private Pala pala1;
    private Pala pala2;
    private Pala pala3;
    private Pala pala4;
    private Vari vari;

    public ZPalikka() {
        this.pala1 = new Pala(0, 0, Vari.PINK);
        this.pala2 = new Pala(0, 1, Vari.PINK);
        this.pala3 = new Pala(1, 0, Vari.PINK);
        this.pala4 = new Pala(-1, 1, Vari.PINK);
    }
}
