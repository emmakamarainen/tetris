

package palikkapeli.palikat;


public class LPalikka {
    private Pala pala1;
    private Pala pala2;
    private Pala pala3;
    private Pala pala4;
    private Vari vari;


    public LPalikka() {
        this.pala1 = new Pala(0,0, Vari.CYAN);
        this.pala2 = new Pala(0,1, Vari.CYAN);
        this.pala3 = new Pala(0,2, Vari.CYAN);
        this.pala4 = new Pala(1,0, Vari.CYAN);
    }
    
}
