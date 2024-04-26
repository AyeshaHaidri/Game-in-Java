import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.*;

public class Board extends JPanel{
    Timer timer;
    BufferedImage backgroundImage;
    Player player;
    Enemy enemies[]=new Enemy[3];
  
    public Board() 
    {
        setSize(1500,920);
        loadBackgroundImage();
        player=new Player();
        gameLoop();
        loadEnemies();
        bindEvents();
        setFocusable(true);
    }
    private void gameOver(Graphics pen)
    {
        if(player.outOfScreen())
        {
            pen.setFont(new Font("times",Font.BOLD,30));
            pen.setColor(Color.RED);
            pen.drawString("Game Won ",1200/2,900/2);
            timer.stop();
            return;
            
        }
        for(Enemy enemy: enemies)
        {
            if(isCollide(enemy))
            {
                pen.setFont(new Font("times",Font.BOLD,30));
                pen.setColor(Color.RED);
                pen.drawString("Game Over ",1200/2,900/2);
                timer.stop();
            }
        }
    }
    
    private boolean isCollide(Enemy enemy)
    {
       int xDistance= Math.abs(player.x - enemy.x);
       int yDistance= Math.abs(player.y - enemy.y);
       int maxH=Math.max(player.h,enemy.h);
       int maxW=Math.max(player.w,enemy.w);
       return xDistance<=maxW-100 && yDistance<=maxH-100;
    }
    private void bindEvents()
    {
       addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e)
        {
            
        }
        @Override
        public void keyReleased(KeyEvent e)
        {
            player.speed=0;
        }
        @Override
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            {
                player.speed=8;
            }
            else if(e.getKeyCode()== KeyEvent.VK_LEFT)
            {
                player.speed=-8;
            }
           
        }
       });
    }
    private void loadEnemies()
    { 
        int x=400; int gap=400;
        int speed=3;
        for(int i=0;i<enemies.length;i++)
        {
            enemies[i]=new Enemy(x,speed);
            x=x+gap;
            speed=speed+3;
        }
    }
    private void gameLoop()
    {
        timer = new Timer(50,(e)->
        {
            repaint();
            gameOver(getGraphics());
        });

        timer.start();
    }
    private void loadBackgroundImage()
    {
        
        // because read creates a exception
        try{

            backgroundImage=ImageIO.read(Board.class.getResource("Game-bg.jpg")); 
        } catch(IOException e)
        {
            System.out.println("Background image not found..."); 
            System.exit(1);
            e.printStackTrace(); 
        }
    }
    private void printenemies(Graphics pen)
    {
        for(Enemy enemy: enemies)
        {
            enemy.draw(pen);
            enemy.move();
        }
    }

    @Override //matlab jcomponent is a parent of paintcomponent which has the same method of pen
    public void paintComponent(Graphics pen)
    {
        //all printing logic will be written here using the pen of graphics  
        super.paintComponent(pen); //super is used to access the obj of parent (jcomp here) clean up any previous paint
        pen.drawImage(backgroundImage,0,0,1500,920,null);
        player.draw(pen);
        player.move();
        printenemies(pen);
        gameOver(pen);
    }
    public static void main(String[] args) {
        
    }
}

