import javax.swing.ImageIcon;

public class Enemy extends Sprites {
    public Enemy( int x,int speed)
    {
        this.speed=speed;
        w=150;
        h=150;
        this.x=x;
        y=30;
        image=new ImageIcon(Enemy.class.getResource("Enemy-image.gif"));
    }
    public void move()
    {
        if(y>900)
        {
            y=0;
        }
        y=y+speed;
    }
}
