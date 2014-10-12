package palikkapeli.pelilogiikka;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import palikkapeli.objektit.Pala;
import palikkapeli.objektit.Palikka;

public class TetrisTest {

    private Palikka palikka;
    private Tetris tetris;

    public TetrisTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tetris = new Tetris();
        palikka = new Palikka();
        palikka.luoPalikanPalat();
        tetris.setLiikkuvaPalikka(palikka);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void LiikuAlasLiikuttaaPalikkaaAlas() {
        int y = palikka.getPalat().get(0).getY();
        tetris.liikuAlas();
        assertEquals(y + 1, palikka.getPalat().get(0).getY());
    }

    @Test
    public void LiikuOikealleLiikuttaaPalikkaaOikealle() {
        int x = palikka.getPalat().get(0).getX();
        tetris.liikuOikealle();
        assertEquals(x + 1, palikka.getPalat().get(0).getX());
    }

    @Test
    public void LiikuVasemmalleLiikuttaaPalikkaaVasemmalle() {
        int x = palikka.getPalat().get(3).getX();
        tetris.liikuVasemmalle();
        assertEquals(x - 1, palikka.getPalat().get(3).getX());
    }

    @Test
    public void EiLiikuVasemmalleJosReunassa() {
        int i = 0;
        for (Pala pala : palikka.getPalat()) {
            pala.setXY(i, i);
            i++;
        }
        int x = palikka.getPalat().get(2).getX();
        tetris.liikuVasemmalle();
        assertEquals(x, palikka.getPalat().get(2).getX());
    }

    @Test
    public void EiLiikuOikealleJosReunassa() {
        int i = 6;
        for (Pala pala : palikka.getPalat()) {
            pala.setXY(i, i);
            i++;
        }
        int x = palikka.getPalat().get(2).getX();
        tetris.liikuOikealle();
        assertEquals(x, palikka.getPalat().get(2).getX());
    }

    @Test
    public void EiKaannyJosVasemmassaReunassa() {
        int i = 0;
        for (Pala pala : palikka.getPalat()) {
            pala.setXY(i, i);
            i++;
        }
        int x = palikka.getPalat().get(2).getX();
        tetris.kaanna();
        assertEquals(x, palikka.getPalat().get(2).getX());
    }

    @Test
    public void EiKaannyJosOikeassaReunassa() {
        int i = 6;
        for (Pala pala : palikka.getPalat()) {
            pala.setXY(i, i);
            i++;
        }
        int x = palikka.getPalat().get(2).getX();
        tetris.kaanna();
        assertEquals(x, palikka.getPalat().get(2).getX());
    }

    @Test
    public void EiLiikuPalanPaalle() {
        Palikka palikka2 = new Palikka();
        palikka2.luoPalikanPalat();
        tetris.liikkuvastaPalikastaPysahtynyt();
        tetris.setLiikkuvaPalikka(palikka2);
        tetris.asetaPalatLaudalle();
        int y = palikka2.getPalat().get(2).getY();
        assertEquals(y, palikka.getPalat().get(2).getY());
    }

    @Test
    public void LiikkuvastaPysahtynyt() {
        tetris.liikkuvastaPalikastaPysahtynyt();
        assertEquals(4, tetris.getPysahtyneet().size());
    }

    @Test
    public void LiikkuvastaPysahtynytKahdesti() {
        tetris.liikkuvastaPalikastaPysahtynyt();
        Palikka palikka2 = new Palikka();
        palikka2.luoPalikanPalat();
        tetris.setLiikkuvaPalikka(palikka2);
        tetris.liikkuvastaPalikastaPysahtynyt();
        assertEquals(8, tetris.getPysahtyneet().size());
    }

    @Test
    public void GetLiikkuvaPalikkaPalauttaaOikein() {
        Palikka palikka2 = new Palikka();
        tetris.setLiikkuvaPalikka(palikka2);
        assertEquals(palikka2, tetris.getLiikkuva());
    }

    @Test
    public void LopetaLopettaaPelin() {
        tetris.lopeta();
        assertEquals(true, tetris.getPeliloppu());
    }

    @Test
    public void PoistaaPysahtyneenPalanJosPalaListalla() {
        tetris.liikkuvastaPalikastaPysahtynyt();
        System.out.println(tetris.getPysahtyneet().size());
        Pala pala = tetris.getPysahtyneet().get(0);
        tetris.poistaPysahtynytPala(pala);
        assertEquals(3, tetris.getPysahtyneet().size());
    }

    @Test
    public void NopeusKasvaaOikein() {
        tetris.kasvataNopeutta();
        assertEquals(750, tetris.getNopeus());
    }

    @Test
    public void LiikuttaaRivejaAlaspain() {
        tetris.liikkuvastaPalikastaPysahtynyt();
        Pala pala = tetris.getPysahtyneet().get(0);
        int y = pala.getY();
        tetris.yksiRiviAlaspain(y + 1);
        assertEquals(y + 1, tetris.getPysahtyneet().get(0).getY());
    }
    
    @Test
    public void etsiPoistettavatPalatLoytaa() {
        tetris.liikkuvastaPalikastaPysahtynyt();
        Pala pala = tetris.getPysahtyneet().get(0);
        int y = pala.getY();
        assertEquals(1, tetris.etsiPoistettavatPalat(y).size());
    }
}
