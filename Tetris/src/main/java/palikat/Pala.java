package palikat;

public class Pala {

   private int pituus = 50;
   private int leveys = 50;
   private int x = 0;
   private int y = 0;  

    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int SetX(int x){
        return x;
    }
    
    public int SetY(int y){
        return y;
    }
}
