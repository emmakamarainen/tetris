package palikkapeli.grafiikka;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import palikkapeli.objektit.Pala;
import palikkapeli.pelilogiikka.Tetris;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Tetris tetris;
    private Font fontti;
    private Font loppufontti;

    public Piirtoalusta(Tetris tetris) {
        this.tetris = tetris;
        super.setBackground(Color.LIGHT_GRAY);
        fontti = new Font("Courier", Font.PLAIN, 20);
        loppufontti = new Font("Arial", Font.PLAIN, 50);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.drawRect(50, 50, 300, 600);

        if (tetris.getPeliloppu()) {
            g.setColor(Color.BLACK);
            g.drawRect(0, 0, 600, 700);
            g.fillRect(0, 0, 600, 700);
            g.setColor(Color.WHITE);
            g.setFont(loppufontti);
            g.drawString("GAME OVER", 150, 300);
//            g.setFont(fontti);
//            g.drawString("paina SPACE aloittaaksesi uuden pelin", 150, 350);
        } else if (!tetris.getPeliloppu()) {

            if (!tetris.getPysahtyneet().isEmpty()) {
                for (int i=0 ;i< tetris.getPysahtyneet().size();i++) {
//                System.out.println("Pysähtyneet palat");               
                        g.setColor(tetris.getPysahtyneet().get(i).getVari());
                        g.fillRect(tetris.getPysahtyneet().get(i).getX() * 30 + 50, tetris.getPysahtyneet().get(i).getY() * 30 + 50, 30, 30);
                        g.setColor(Color.BLACK);
                        g.drawRect(tetris.getPysahtyneet().get(i).getX() * 30 + 50, tetris.getPysahtyneet().get(i).getY() * 30 + 50, 30, 30);
                    
                }
            }

            if (!tetris.getPeliloppu()) {
                for (Pala pala : tetris.getLiikkuva().getPalat()) {
//            System.out.println("Liikkuva pala");
                    g.setColor(pala.getVari());
                    g.fillRect(pala.getX() * 30 + 50, pala.getY() * 30 + 50, 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(pala.getX() * 30 + 50, pala.getY() * 30 + 50, 30, 30);
                }
            }

            g.setColor(Color.GRAY);
            g.setFont(fontti);
            g.drawString("Pisteet:", 370, 100);
            g.drawString("" + tetris.getPisteet(), 370, 150);
            g.drawString("YLÖS - kääntää", 370, 300);
            g.drawString("VASEN - vasemmalle", 370, 350);
            g.drawString("OIKEA - oikealle", 370, 400);
        }
    }

    @Override
    public void paivita() {
        super.repaint();
    }
}
