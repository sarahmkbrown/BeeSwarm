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
    private int x = r.nextInt(BeeSwarm.windowWidth);
    private int y = r.nextInt(BeeSwarm.windowHeight);
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

    public void update()
    {
        if (x < BeeSwarm.windowWidth / 2)
        {
            x += 5;
        } else if (x > BeeSwarm.windowWidth/2)
        {
            x -= 5;
        }
        if (y < BeeSwarm.windowHeight / 2)
        {
            y += 5;
        } else if (y > BeeSwarm.windowHeight / 2)
        {
            y -= 5;
        }
    }
}
