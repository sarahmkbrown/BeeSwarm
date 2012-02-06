package org.wintrisstech;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * This project is designed as a starting point for students learning about
 * arrays. <p> Images in this project are public domain from
 * http://openclipart.org
 *
 * @author aaron@wintrisstech.org (Aaron VonderHaar)
 * @author http://wintrisstech.org
 */
public class BeeSwarm extends JComponent implements ActionListener
{

    private Image background;
    
    public static final int windowHeight = 751;
    public static final int windowWidth = 1024;

    private Flower[] f = new Flower[20];
    private QueenBee q = new QueenBee();

    public static void main(String[] args) throws IOException
    {
        JFrame window = new JFrame("Bees!");
        BeeSwarm game = new BeeSwarm();
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        Timer t = new Timer(30, game);
        t.start();
    }

    public BeeSwarm() throws IOException
    {
        background = ImageIO.read(getClass().getResource("carlitos_Cartoon_Landscape.png"));
        
        for(int i = 0; i < f.length; i++) {
            f[i] = new Flower();
        }
        
        // Initialize the queen's position
        q.update();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(windowWidth, windowHeight);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(background, 0, 0, windowWidth, windowHeight, null);
        
        for(int i = 0; i < f.length; i++) {
            g.drawImage(f[i].image, f[i].x, f[i].y, f[i].width, f[i].height, null);
        }

        q.paint(g);

    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        q.update();

        repaint();
    }

   
}
