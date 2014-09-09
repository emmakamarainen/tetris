
package palikat;

public class IPalikka {
    private Pala pala1;
    private Pala pala2;
    private Pala pala3;
    private Pala pala4;
    private Vari vari;

    public IPalikka() {
        this.pala1 = new Pala(0,0, Vari.BLUE);
        this.pala2 = new Pala(0,1, Vari.BLUE);
        this.pala3 = new Pala(0,2, Vari.BLUE);
        this.pala4 = new Pala(0,3, Vari.BLUE);
    }
    
}
