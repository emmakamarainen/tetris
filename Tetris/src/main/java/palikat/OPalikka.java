package palikat;

public class OPalikka {

    private Pala pala1;
    private Pala pala2;
    private Pala pala3;
    private Pala pala4;
    private Vari vari;


    public OPalikka() {
        this.pala1 = new Pala(0,0, Vari.RED);
        this.pala2 = new Pala(0,1, Vari.RED);
        this.pala3 = new Pala(1,0, Vari.RED);
        this.pala4 = new Pala(1,1, Vari.RED);
    }
}
