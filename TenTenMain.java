import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.Box;

public class TenTen extends JFrame
{
 
private PiecePanel piecePanel;
private ScorePanel scorePanel;
  
public TenTen()
{
  LetterPanel scorekeeper = new LetterPanel(this);
  piecepanel = new PiecePanel();
  whiteboard.setScoreDisplay(piecepanel);
  piecepanel.addMouseListener(new GameMouseListener());
  
  Box box = Box.createVerticalBox();
    box.add(scorekeeper);
    box.add(scorePanel);
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
         
    new SwingApplication(); //Create and show the GUI. 
    TenTen window = new TenTen();
    window.setBounds(100, 100, 395, 355);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
  
  
}

