package Pelilauta;

import java.util.ArrayList;

public class Pelilauta {

    private int[][] lauta;
    private int poistetutRivit;

    public Pelilauta() {
        this.lauta = new int[10][20];
        poistetutRivit = 0;
    }

    /**
     * Laittaa uuden palan ruutuun, jos se on tyhjä.
     */
    public void asetaPalaRuutuun(int x, int y) {
        if (onkoRuudussaPala(x, y) == false) {
            lauta[x][y] = 1;
//            System.out.println("OK");
        }
    }

    /**
     * Jos meinaa asettaa palan laudan ulkopuolelle niin siinä onkin jo pala!
     * Oon nero. Testaa onko ruudussa pala.
     */
    public boolean onkoRuudussaPala(int x, int y) {
        if (x >= 10 || x < 0 || y >= 20 || y < 0) {
            return true;
        }
        if (lauta[x][y] == 0) {
            return false;
        }
        return true;
    }

    /**
     * Käy läpi pelilaudan ja palauttaa listan täysistä riveistä.
     */
    public ArrayList<Integer> taysienRivienLista() {
        ArrayList<Integer> Rivit = new ArrayList<>();
        int nro = 0;
        for (int rivi = 0; rivi < lauta.length; rivi++) {
            boolean rivitaysi = true;
            for (int sarake = 0; sarake < lauta.length; sarake++) {
                if (lauta[sarake][rivi] == 0) {
                    rivitaysi = false;
                    break;
                }
            }
            if (rivitaysi==true) {
                Rivit.add(nro, rivi);
                nro++;
            }
        }
        return Rivit;
    }

    /**
     * Apumetodi edelliseen, tarkistaa onko listalla olevat alkiot samat.
     */
    public boolean listanKaikkiAlkiotSamat(ArrayList<Integer> lista) {
        for (int alkio : lista) {
            if (alkio == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Poistaa yhden rivin.
     */
    public void poistaRivi(int rivinro) {
        for (int alkionro = 0; alkionro < 10; alkionro++) {
            lauta[rivinro][alkionro] = 0;
            lisaaRivi();
        }
    }

    /**
     * Poistaa kaikki täydet rivit.
     */
    public void poistaTaydetRivit() {
        for (int rivi : taysienRivienLista()) {
            poistaRivi(rivi);
        }
    }

    public void tulosta() {
//        for (int i = 0; i < 10; i++) {
//            System.out.print(lauta[i][0]);
//        } Testi
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
