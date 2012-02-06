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

    public void update(QueenBee q, Bee[] b)
    {
        float xDesire = 0;
        float yDesire = 0;

        if (x < q.x)
        {
            xDesire += 5;
        } else
        {
            xDesire -= 5;
        }
        if (y < q.y)
        {
            yDesire += 5;
        } else
        {
            yDesire -= 5;
        }

        for (int i = 0; i < b.length; i++)
        {
            if (x < b[i].x)
            {
                xDesire -= .3;
            } else
            {
                xDesire += .3;
            }
            if (y < b[i].y)
            {
                yDesire -= .3;
            } else
            {
                yDesire += .3;
            }

        }

        x += xDesire;
        y += yDesire;

    }
}
