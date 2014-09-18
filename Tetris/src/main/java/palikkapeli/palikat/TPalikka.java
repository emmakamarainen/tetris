

package palikkapeli.palikat;


public class TPalikka {
    private Pala pala1;
    private Pala pala2;
    private Pala pala3;
    private Pala pala4;
    private Vari vari;


    public TPalikka() {
        this.pala1 = new Pala(0,0, Vari.GREEN);
        this.pala2 = new Pala(1,0, Vari.GREEN);
        this.pala3 = new Pala(2,0, Vari.GREEN);
        this.pala4 = new Pala(1,1, Vari.GREEN);
    }
    
}
