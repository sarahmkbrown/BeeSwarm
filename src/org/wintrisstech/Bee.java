package org.wintrisstech;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Bee {
    
    private Image image;
    private Random r = new Random();
    private int x = r.nextInt(BeeSwarm.windowWidth);
    private int y = r.nextInt(BeeSwarm.windowHeight);
    private final int width = 20;
    private final int height = 20;

    public Bee() throws IOException
    {
        image = ImageIO.read(getClass().getResource("bee_left.png"));
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(image, x, y, width, height, null);
    }
    
    
}
