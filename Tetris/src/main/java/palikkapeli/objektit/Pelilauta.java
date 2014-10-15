package palikkapeli.objektit;

import java.util.ArrayList;

/**
 * * Tetriksen pelilauta.
 *
 * Palat asetetaan ruutuihin, tai otetaan niistä pois. Hoitaa myös
 * pisteidenlaskun.
 *
 * @author Emma
 */
public class Pelilauta {

    private int[][] lauta;
    private int poistetutRivit;

    public Pelilauta() {
        this.lauta = new int[10][20];
        poistetutRivit = 0;
    }

    /**
     * Laittaa uuden palan ruutuun, jos se on tyhjä.
     *
     * @param x ruudun x-koordinaatti
     * @param y ruudun y-koordinaatti
     */
    public void asetaPalaRuutuun(int x, int y) {
        if (onkoRuudussaPala(x, y) == false) {
            lauta[x][y] = 1;
        }
    }

    /**
     * Jos meinaa asettaa palan laudan ulkopuolelle niin siinä onkin jo pala!
     * Testaa onko ruudussa pala.
     *
     * @param x testattavan ruudun x-koordinaatti
     * @param y testattavan ruudun y-koordinaatti
     * @return palauttaa true/false riippuen onko ruudussa pala
     */
    public boolean onkoRuudussaPala(int x, int y) {
        if (x >= 10 || x < 0 || y >= 20 || y < 0) {
//            System.out.println("Reuna");
            return true;
        }
        if (lauta[x][y] == 0) {
//            System.out.println("ei palaa");
            return false;
        }
        return true;
    }

    /**
     * Käy läpi pelilaudan ja palauttaa listan täysistä riveistä.
     *
     * @return lista täysistä riveistä
     */
    public ArrayList<Integer> taysienRivienLista() {
        ArrayList<Integer> Rivit = new ArrayList<>();
        for (int rivi = 0; rivi < 20; rivi++) {
            boolean rivitaysi = true;
            for (int sarake = 0; sarake < 10; sarake++) {
                if (lauta[sarake][rivi] == 0) {
                    rivitaysi = false;
                    break;
                }
            }
            if (rivitaysi == true) {
                Rivit.add(rivi);
            }
        }

        return Rivit;

    }

    /**
     * Poistaa yhden rivin ja kasvattaa poistettujen rivien lukua.
     *
     * @param rivinro pistettavan rivin rivinumero
     */
    public void poistaRivi(int rivinro) {
        if (rivinro < 0 || rivinro > 20) {
            return;
        }
        for (int alkionro = 0; alkionro < 10; alkionro++) {
            lauta[alkionro][rivinro] = 0;
        }
        lisaaRivi();
    }

    /**
     * Poistaa kaikki täydet rivit ja kasvattaa poistettujen rivien lukumäärää.
     */
    public void poistaTaydetRivit() {
        if (!taysienRivienLista().isEmpty()) {
            for (int rivi : taysienRivienLista()) {
                poistaRivi(rivi);
                lisaaRivi();
            }
            taysienRivienLista().clear();
        }
    }

    /**
     * Kasvattaa poistettujen rivien lukua, käytetään pisteidenlaskussa
     */
    public int lisaaRivi() {
        return poistetutRivit++;
    }

    public int GetRivit() {
        return poistetutRivit;
    }

    public int[][] GetLauta() {
        return lauta;
    }

    /**
     * Laittaa poistettujen rivien luvun nollaksi.
     */
    public void nollaaRivit() {
        poistetutRivit = 0;
    }

    /**
     * Poistaa jokaisen palan laudalta.
     */
    public void nollaaLauta() {
        for (int rivi = 0; rivi < 20; rivi++) {
            for (int sarake = 0; sarake < 10; sarake++) {
                lauta[sarake][rivi] = 0;
            }

        }
    }

    
}
