import  javax.swing.JFrame;

public class GameFrame extends JFrame{
    public GameFrame()
    {
        Board board=new Board();
        setTitle("Game Dev in Java");
        setSize(1500,920);
        setVisible(true);
        add(board);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
    }
}