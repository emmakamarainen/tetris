package palikkapeli.objektit;

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
    public void onkoRuudussaPalaAariarvotPt1() {
        assertEquals(true, pelilauta.onkoRuudussaPala(10, 2));
    }

    @Test
    public void onkoRuudussaPalaAariarvotPt2() {
        assertEquals(false, pelilauta.onkoRuudussaPala(0, 2));
    }

    @Test
    public void onkoRuudussaPalaAariarvotPt3() {
        assertEquals(true, pelilauta.onkoRuudussaPala(2, 20));
    }

    @Test
    public void onkoRuudussaPalaAariarvotPt4() {
        assertEquals(false, pelilauta.onkoRuudussaPala(2, 0));
    }

    @Test
    public void eiLisaaPalaaRuudunUlkopuolellexPienempiKuin0() {
        pelilauta.asetaPalaRuutuun(-1, 2);
        assertEquals(true, pelilauta.onkoRuudussaPala(-1, 2));
    }

    @Test
    public void eiLisaaPalaaRuudunUlkopuolelleXOn10() {
        pelilauta.asetaPalaRuutuun(10, 2);
        assertEquals(true, pelilauta.onkoRuudussaPala(10, 2));
    }

    @Test
    public void eiLisaaPalaaRuudunUlkopuolelleYOn20() {
        pelilauta.asetaPalaRuutuun(5, 20);
        assertEquals(true, pelilauta.onkoRuudussaPala(5, 20));
    }

    @Test
    public void eiLisaaPalaaRuudunUlkopuolelleYOnPienempiKuin0() {
        pelilauta.asetaPalaRuutuun(5, -1);
        assertEquals(true, pelilauta.onkoRuudussaPala(5, -1));
    }

    @Test
    public void josLaudallaTaysiRiviLisaaSenListaan() {
        for (int i = 0; i <= 10; i++) {
            pelilauta.asetaPalaRuutuun(i, 1);
        }
        for (int i = 0; i <= 10; i++) {
            pelilauta.asetaPalaRuutuun(i, 2);
        }
        pelilauta.taysienRivienLista();
        assertEquals(2, pelilauta.taysienRivienLista().size());
    }

    @Test
    public void riviLisaantyyOikein() {
        pelilauta.lisaaRivi();
        pelilauta.lisaaRivi();
        assertEquals(2, pelilauta.GetRivit());
    }

    @Test
    public void riviLisaantyyKunRiviPoistetaan() {
        for (int i = 0; i < 10; i++) {
            pelilauta.asetaPalaRuutuun(i, 1);
        }
        pelilauta.poistaRivi(1);
        assertEquals(1, pelilauta.GetRivit());
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

    @Test
    public void nollaaLautaNollaaKaiken() {
        pelilauta.nollaaLauta();
        for (int rivi = 0; rivi < 20; rivi++) {
            for (int sarake = 0; sarake < 10; sarake++) {
                assertEquals(0, pelilauta.GetLauta()[sarake][rivi]);
            }
        }
    }

    @Test
    public void poistaTaydetRivitLisaaPisteita() {
        for (int y = 0; y < 1; y++) {
            for (int x = 0; x < 11; x++) {
                pelilauta.asetaPalaRuutuun(x, y);
            }
        }
        pelilauta.poistaTaydetRivit();
        assertEquals(2, pelilauta.GetRivit());
    }
}
