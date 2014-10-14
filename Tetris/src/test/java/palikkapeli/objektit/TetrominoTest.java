
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
    public void randomLukuSuurempiTAiYhtaSuuriKuinNolla(){        
        assertEquals(tetromino.mikaPalikka()>=0,true);        
    }
    
    @Test
    public void randomLukuPienempiKuinSeitsemän(){        
        assertEquals(tetromino.mikaPalikka()<7,true);        
    }
    
    @Test
    public void uusiTetrominoLuoPalikan(){        
        assertNotNull(tetromino.luoTetromino());        
    }
    
    
    
}
