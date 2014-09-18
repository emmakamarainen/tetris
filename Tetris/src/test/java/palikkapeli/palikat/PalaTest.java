package palikkapeli.palikat;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PalaTest {

    private Pala pala;

    public PalaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.pala = new Pala(5, 5, Vari.GREEN);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void getXPalauttaaOikeanX(){
        assertEquals(5, pala.GetX());
    }
    
    @Test
    public void getXPalauttaaOikeanY(){
        assertEquals(5, pala.GetY());
    }
    
    @Test
    public void PalaOsuuPalauttaaTrueJosOsuu(){
        Pala pala2 = new Pala(5,5,Vari.BLUE);
        assertEquals(true, pala.PalaOsuu(pala2));
    }
    
    @Test
    public void PalaOsuuPalauttaaFalseJosEiOsu(){
        Pala pala2 = new Pala(6,5,Vari.BLUE);
        assertEquals(false, pala.PalaOsuu(pala2));
    }
}
