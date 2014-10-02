
package palikkapeli.objektit;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TetrominoTest {
    
    private Tetromino tetromino;
    
    public TetrominoTest() {
        
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {        
        tetromino=new Tetromino();
        
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void IOnVihrea(){
        Palikka palikka = tetromino.luoTetromino(0);
        assertEquals(tetromino.getVari(0),palikka.GetVari());        
    }
    
    @Test
    public void JOnPunainen(){
        Palikka palikka = tetromino.luoTetromino(1);
        assertEquals(tetromino.getVari(1),palikka.GetVari());        
    }
    
    @Test
    public void LOnPinkki(){
        Palikka palikka = tetromino.luoTetromino(2);
        assertEquals(tetromino.getVari(2),palikka.GetVari());        
    }
    
    @Test
    public void OOnKeltainen(){
        Palikka palikka = tetromino.luoTetromino(3);
        assertEquals(tetromino.getVari(3),palikka.GetVari());        
    }
    
    @Test
    public void SOnSininen(){
        Palikka palikka = tetromino.luoTetromino(4);
        assertEquals(tetromino.getVari(4),palikka.GetVari());        
    }
    
    @Test
    public void TOnSyaani(){
        Palikka palikka = tetromino.luoTetromino(5);
        assertEquals(tetromino.getVari(5),palikka.GetVari());        
    }
    
    @Test
    public void ZOnHarmaa(){
        Palikka palikka = tetromino.luoTetromino(6);
        assertEquals(tetromino.getVari(6),palikka.GetVari());        
    }
}
