import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Sprites {
    int speed;
    int x;int y;int w;int h; 
    ImageIcon image;
    public void draw(Graphics pen)
    {
        pen.drawImage(image.getImage(),x,y,w,h,null );
    }
   
}
