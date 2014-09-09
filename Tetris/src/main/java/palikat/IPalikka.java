
package palikat;

public class IPalikka {
    private Pala pala1;
    private Pala pala2;
    private Pala pala3;
    private Pala pala4;

    public IPalikka() {
        this.pala1 = new Pala(0,0);
        this.pala2 = new Pala(0,1);
        this.pala3 = new Pala(0,2);
        this.pala4 = new Pala(0,3);
    }
    
}
