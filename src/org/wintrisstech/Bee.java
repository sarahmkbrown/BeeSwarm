package org.wintrisstech;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Bee
{

    private Image image;
    private Random r = new Random();
    private int x = r.nextInt(BeeSwarm.windowWidth * 2) - BeeSwarm.windowWidth / 2 ;
    private int y = r.nextInt(BeeSwarm.windowHeight * 2)- BeeSwarm.windowHeight / 2;
    private double vx = 0;
    private double vy = 0;
    private final int width = 20;
    private final int height = 20;
    private int counter = 0;

    public Bee() throws IOException
    {
        image = ImageIO.read(getClass().getResource("bee_left.png"));
    }

    public void paint(Graphics g)
    {
        g.drawImage(image, x - width / 2,
                y - height / 2,
                width, height, null);
    }

    public void update(QueenBee q, Bee[] b)
    {
//        x += vx;
//        y += vy;
        
        double xDesire = 0;
        double yDesire = 0;
        
        xDesire -= (x - q.x) / 40.0;
        yDesire -= (y - q.y) / 40.0;        

        for (int i = 0; i < b.length; i++)
        {
            int dX = x - b[i].x;
            if (Math.abs(dX) < 100) {
                xDesire += dX / 1000.0;            
            }
            int dY = y - b[i].y;
            if (Math.abs(dY) < 100) {
                yDesire += dY / 1000.0;
            }
        }

        x += xDesire;
        y += yDesire;
//        vx += xDesire / 20;
//        vy += yDesire / 20;

    }
}
