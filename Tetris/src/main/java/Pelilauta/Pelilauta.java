package Pelilauta;

public class Pelilauta {

    private int[][] lauta;
    private int poistetutRivit;

    public Pelilauta() {
        this.lauta = new int[10][20];
        poistetutRivit = 0;
    }

    public void asetaPalaRuutuun(int x, int y) {
        if (x >= 10 || x < 0 || y >= 10 || y < 0) {
            try {
                lauta[x][y] = 1;
            } catch (Exception IndexOutOfBoundaries) {
            }
        }
        lauta[x][y] = 1;
    }

    public boolean onkoRuudussaPala(int x, int y) {
        if (lauta[x][y] == 0) {
            return false;
        }
        return true;
    }

    public void tulosta() {
        for (int i = 0; i < 10; i++) {
            System.out.print(lauta[i][0]);
        }
    }

    public void lisaaRivi() {
        poistetutRivit++;
    }

    public int GetRivit() {
        return poistetutRivit;
    }

    public void nollaaRivit() {
        poistetutRivit = 0;
    }
}
