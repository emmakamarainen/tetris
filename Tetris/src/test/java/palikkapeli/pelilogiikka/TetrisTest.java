package palikkapeli.pelilogiikka;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import palikkapeli.grafiikka.Paivitettava;
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
        tetris.SetLiikkuvaPalikka(palikka);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void LiikuAlasLiikuttaaPalikkaaAlas() {
        int y = palikka.getPalat().get(0).GetY();
        tetris.liikuAlas();
        assertEquals(y + 1, palikka.getPalat().get(0).GetY());
    }

    @Test
    public void LiikuOikealleLiikuttaaPalikkaaOikealle() {
        int x = palikka.getPalat().get(0).GetX();
        tetris.liikuOikealle();
        assertEquals(x + 1, palikka.getPalat().get(0).GetX());
    }

    @Test
    public void LiikuVasemmalleLiikuttaaPalikkaaVasemmalle() {
        int x = palikka.getPalat().get(3).GetX();
        tetris.liikuVasemmalle();
        assertEquals(x - 1, palikka.getPalat().get(3).GetX());
    }

    @Test
    public void EiLiikuVasemmalleJosReunassa() {
        int i = 0;
        for (Pala pala : palikka.getPalat()) {
            pala.SetXY(i, i);
            i++;
        }
        int x = palikka.getPalat().get(2).GetX();
        tetris.liikuVasemmalle();
        assertEquals(x, palikka.getPalat().get(2).GetX());
    }

    @Test
    public void EiLiikuOikealleJosReunassa() {
        int i = 6;
        for (Pala pala : palikka.getPalat()) {
            pala.SetXY(i, i);
            i++;
        }
        int x = palikka.getPalat().get(2).GetX();
        tetris.liikuOikealle();
        assertEquals(x, palikka.getPalat().get(2).GetX());
    }

    @Test
    public void EiLiikuPalanPaalle() {
        Palikka palikka2 = new Palikka();
        palikka2.luoPalikanPalat();
        tetris.liikkuvastaPalikastaPysahtynyt();
        tetris.SetLiikkuvaPalikka(palikka2);
        tetris.asetaPalatLaudalle();
        int y = palikka2.getPalat().get(2).GetY();
        assertEquals(y, palikka.getPalat().get(2).GetY());
    }

    @Test
    public void LiikkuvastaPysahtynyt() {
        tetris.liikkuvastaPalikastaPysahtynyt();
        assertEquals(1, tetris.GetPysahtyneetTetriminot().size());
    }

    @Test
    public void LiikkuvastaPysahtynytKahdesti() {
        tetris.liikkuvastaPalikastaPysahtynyt();
        Palikka palikka2 = new Palikka();
        palikka2.luoPalikanPalat();
        tetris.SetLiikkuvaPalikka(palikka2);
        tetris.liikkuvastaPalikastaPysahtynyt();
        assertEquals(2, tetris.GetPysahtyneetTetriminot().size());
    }
    
    @Test
    public void GetLiikkuvaPalikkaPalauttaaOikein(){
        Palikka palikka2 = new Palikka();
        tetris.SetLiikkuvaPalikka(palikka2);
        assertEquals(palikka2, tetris.GetLiikkuvaPalikka());
    }
    
    @Test
    public void LopetaLopettaaPelin(){
        tetris.lopeta();
        assertEquals(true, tetris.GetPeliloppu());
    }
    
    
}
