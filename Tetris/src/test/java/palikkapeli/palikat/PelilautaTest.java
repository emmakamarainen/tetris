package palikkapeli.palikat;

import palikkapeli.objektit.Pelilauta;
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
