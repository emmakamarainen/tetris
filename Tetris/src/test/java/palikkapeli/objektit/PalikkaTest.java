package palikkapeli.objektit;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import palikkapeli.objektit.Pala;
import palikkapeli.objektit.Palikka;

public class PalikkaTest {

    private Palikka palikka;

    public PalikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        palikka = new Palikka();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void LisaaPalaLisaaPalan(){
        Pala pala=new Pala(2,2);
        Pala pala1=new Pala(2,2);
        palikka.lisaaPala(pala);
        palikka.lisaaPala(pala1);
        assertEquals(2, palikka.getPalat().size());        
    }

    @Test
    public void PalikallaOnNeljäPalaa() {
        palikka.luoPalikanPalat();
        assertEquals(4, palikka.getPalat().size());
    }
}
