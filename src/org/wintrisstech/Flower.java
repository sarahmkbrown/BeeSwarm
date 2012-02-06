package org.wintrisstech;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Flower
{

    public static final int typesOfFlowers = 3;
    private Random r = new Random();
    private int x = r.nextInt(1024);
    private int y = r.nextInt(350) + 400;
    private int width = 40;
    private int height = 60;
    private Image image;

    public Flower() throws IOException
    {
        int imageChoice = r.nextInt(3);
        if (imageChoice == 0)
        {
            image = ImageIO.read(getClass().getResource("flowers.png"));
        } else if (imageChoice == 1)
        {
            image = ImageIO.read(getClass().getResource("flower.png"));
        } else if (imageChoice == 2)
        {
            image = ImageIO.read(getClass().getResource("flower111.png"));
        }
    }

    public void paint(Graphics g)
    {
        g.drawImage(image, x, y, width, height, null);
    }
}
