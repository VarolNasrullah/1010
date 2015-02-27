import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.Box;

public class TenTen extends JPanel implements ScoreDisplay
{
 
private PiecePanel piecePanel;
private ScorePanel scorePanel;


public TenTen()
{
  ScorePanel scorekeeper = new ScorePanel();
  piecePanel = new PiecePanel();
  scorekeeper.setScoreDisplay(piecePanel);
  piecePanel.addMouseListener(new GameMouseListener());
  scorePanel.addMouseListener(new GameMouseListener());
  
  Box box = Box.createVerticalBox();
    box.add(scorePanel);
    //add in grid.  
    box.add(piecePanel);
    getContentPane().add(box);

    newGame();
  
}


public void newGame()
  {
    scorePanel.newGame();
  }

public static void main(String[] args)
  {
    try {
            // Set cross-platform Java L&F
        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
    } 
    catch (Exception e) {
       // handle exception
    }
         
    //Create and show the GUI. 
    TenTen game = new TenTen();
    game.setBounds(100, 100, 395, 355);
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.setVisible(true);
  }

@Override
public void update(int score) {
	// TODO Auto-generated method stub
	
}
  
  
}

