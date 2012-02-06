package org.wintrisstech;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class QueenBee
{

    private Image beeLeft;
    private Image beeRight;
    private int lastX;
    private boolean isMovingRight;
    private int x = BeeSwarm.windowWidth / 2;
    private int y = BeeSwarm.windowHeight / 2;
    private int width = 100;
    private int height = width * 75 / 100;
    private int counter = 0;

    public QueenBee() throws IOException
    {
        beeLeft = ImageIO.read(getClass().getResource("bee_left.png"));
        beeRight = ImageIO.read(getClass().getResource("bee_right.png"));
    }

    public void paint(Graphics g)
    {

        if (isMovingRight)
        {
            g.drawImage(beeRight, x - width / 2,
                    y - height / 2,
                    width, height, null);
        } else
        {
            g.drawImage(beeLeft, x - width / 2,
                    y - height / 2,
                    width, height, null);

        }
    }

    public void update()
    {
        // Increment the counter used to calculate cr and ci.  The faster
        // we increment this, the faster the queen will move.
        counter += 2;

        // This is code taken from the Julia screensaver which calculates the 
        // position of a point that wanders around the screen.
        // http://www.jwz.org/xscreensaver/
        double cr = 1.5 * (Math.sin(Math.PI * (counter / 290.0))
                * Math.sin(counter * Math.PI / 210.0));
        double ci = 1.5 * (Math.cos(Math.PI * (counter / 310.0))
                * Math.cos(counter * Math.PI / 190.0));

        cr += 0.5 * Math.cos(Math.PI * counter / 395.0);
        ci += 0.5 * Math.sin(Math.PI * counter / 410.0);

        // Save the queen's last X position so we can calculate later which
        // direction it is moving
        lastX = x;

        // Convert cr and ci (which range from -2 to +2) into X-Y coordinates
        // in our window
        x = (int) ((cr + 2) / 4 * BeeSwarm.windowWidth);
        y = (int) ((ci + 2) / 4 * BeeSwarm.windowHeight);

        // Calculate whether the queen is moving right or left
        if (x > lastX)
        {
            isMovingRight = true;
        } else
        {
            isMovingRight = false;
        }
    }
}
