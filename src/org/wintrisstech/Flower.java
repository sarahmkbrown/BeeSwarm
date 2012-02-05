package org.wintrisstech;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Flower {
    
    public int x = 500;
    public int y = 500;
    public int width = 40;
    public int height = 60;
    public Image image;

    public Flower() throws IOException
    {
        image = ImageIO.read(getClass().getResource("flowers.png"));
    }
    
    

}
