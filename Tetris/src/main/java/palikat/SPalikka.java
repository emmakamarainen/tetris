
package palikat;

public class SPalikka {
    private Pala pala1;
    private Pala pala2;
    private Pala pala3;
    private Pala pala4;
    private Vari vari;


    public SPalikka() {
        this.pala1 = new Pala(0,0, Vari.ORANGE);
        this.pala2 = new Pala(1,0, Vari.ORANGE);
        this.pala3 = new Pala(1,1, Vari.ORANGE);
        this.pala4 = new Pala(2,1, Vari.ORANGE);
    }
    
}
