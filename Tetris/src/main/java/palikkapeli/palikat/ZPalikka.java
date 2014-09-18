<<<<<<< HEAD:Tetris/src/main/java/palikat/ZPalikka.java
package palikat;
=======

package palikkapeli.palikat;
>>>>>>> 90faca4c0658fa1e708de348ad22cce8722b7c65:Tetris/src/main/java/palikkapeli/palikat/ZPalikka.java

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
