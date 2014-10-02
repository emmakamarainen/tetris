package palikkapeli.grafiikka;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import palikkapeli.objektit.Pala;
import palikkapeli.objektit.Palikka;
import palikkapeli.pelilogiikka.Tetris;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Tetris tetris;
    private Font fontti;

    public Piirtoalusta(Tetris tetris) {
        this.tetris = tetris;
        super.setBackground(Color.LIGHT_GRAY);
        fontti = new Font("Courier", Font.PLAIN, 20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.drawRect(20, 20, 450, 620);

//        for (Palikka palikka : tetris.GetPysahtyneetTetriminot()) {
//            System.out.println("Pysähtyneet palat");
//            for (Pala pala : palikka.getPalat()) {
//                g.setColor(pala.GetVari());
//                g.fillRect(pala.GetX() * 30 + 20, pala.GetY() * 30 + 20, 30, 30);
//                g.setColor(Color.BLACK);
//                g.drawRect(pala.GetX() * 30 + 20, pala.GetY() * 30 + 20, 30, 30);
//            }
//        }


        for (Pala pala : tetris.GetLiikkuvaPalikka().getPalat()) {
            System.out.println("Liikkuva pala");
            g.setColor(pala.GetVari());
            g.fillRect(pala.GetX() * 30 + 50, pala.GetY() * 30 + 20, 30, 30);
            g.setColor(Color.BLACK);
            g.drawRect(pala.GetX() * 30 + 50, pala.GetY() * 30 + 20, 30, 30);
        }

        g.setColor(Color.GRAY);
        g.setFont(fontti);
        g.drawString("Pisteet:", 500, 100);
        g.drawString("" + tetris.getPisteet(), 500, 150);
    }

    @Override
    public void paivita() {
        super.repaint();
    }
}