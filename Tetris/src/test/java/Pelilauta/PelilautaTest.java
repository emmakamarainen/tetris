package Pelilauta;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PelilautaTest {

    private Pelilauta pelilauta;

    public PelilautaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.pelilauta = new Pelilauta();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void josRuudussaEiPalaaPalauttaaFalse() {
        assertEquals(false, pelilauta.onkoRuudussaPala(1, 2));
    }

    @Test
    public void josRuudussaPalaPalauttaaTrue() {
        pelilauta.asetaPalaRuutuun(1, 2);
        assertEquals(true, pelilauta.onkoRuudussaPala(1, 2));
    }

    @Test
    public void eiLisaaPalaaRuudunUlkopuolelle() {
        pelilauta.asetaPalaRuutuun(-1, 2);
        assertEquals(true, pelilauta.onkoRuudussaPala(-1, 2));
    }

    @Test
    public void ListanKaikkiAlkiotSamatPalauttaaTrueKunAlkiotOvatSamat() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            lista.add(1);
        }
        assertEquals(true, pelilauta.listanKaikkiAlkiotSamat(lista));
    }

    @Test
    public void ListanKaikkiAlkiotSamatPalauttaaFalseKunAlkiotEivatOleSamat() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            lista.add(1);
        }
        lista.add(0);
        assertEquals(false, pelilauta.listanKaikkiAlkiotSamat(lista));
    }

////    @Test
////    public void josLaudallaTaysiRiviLisaaSenListaan() {
////        for (int i = 0; i < 10; i++) {
////            pelilauta.asetaPalaRuutuun(1, i);
////        }
////        for (int i = 0; i < 10; i++) {
////            pelilauta.asetaPalaRuutuun(2, i);
////        }
////        pelilauta.TaysienRivienLista();
////        int rivilkm = pelilauta.TaysienRivienLista().size();
////        assertEquals(1, rivilkm);
////    }
    
    @Test
    public void riviLisaantyyOikein() {
        pelilauta.lisaaRivi();
        pelilauta.lisaaRivi();
        assertEquals(2, pelilauta.GetRivit());
    }

    @Test
    public void riviNollaantuuOikein() {
        pelilauta.lisaaRivi();
        pelilauta.lisaaRivi();
        pelilauta.nollaaRivit();
        assertEquals(0, pelilauta.GetRivit());
    }

    @Test
    public void palauttaaOikeanRivimaaran() {
        for (int i = 0; i < 10; i++) {
            pelilauta.lisaaRivi();
        }
        assertEquals(10, pelilauta.GetRivit());
    }
}
