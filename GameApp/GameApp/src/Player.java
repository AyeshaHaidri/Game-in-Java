import javax.swing.ImageIcon;
public class Player extends Sprites
{
    public Player()
    {
        w=200;
        h=200;
        x=10;
        y=615;
        image=new ImageIcon(Player.class.getResource("Player-image.gif"));
    }
    public void move()
    {
        x=x+speed;
    }
    public boolean outOfScreen()
    {
        return x>1400;
    }
}
  