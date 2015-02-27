
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box;

public class ScorePanel extends JPanel implements ScoreDisplay
{
 public int score; //variable that contains current score
 public int[] countRow = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
 public int[] countColumn = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
 public int count;
 TenTenCharMatrix tenTenCharMatrix = new TenTenCharMatrix(10,10); //make a TenTenCharMatrix class variable
 Piece piece = new Piece();
 PiecePanel piecePanel = new PiecePanel();
 private JTextField scorekeeper;
 private JButton newGame;
 private JButton help;
 private ScoreDisplay scoreDisplay;
 
 //method for calculating current score
 //incomplete because there is no operation for 
 //adding scores for blocks placed in the matrix yet
 public void calculateScore()
 {
  // check which rows are full
  // add one to count for each full row
  for (int c=0; c<tenTenCharMatrix.numRows();c++)
  {
   if (tenTenCharMatrix.rowFull(c))
   {
    countRow[c]=1;
    count++;
   }
  }
  
  // same for columns
  for (int c=0; c<tenTenCharMatrix.numCols();c++)
  {
   if (tenTenCharMatrix.columnFull(c))
   {
    countColumn[c]=1;
    count++;
   }
  }
  score += 5*count*(count+1); // add score for all full rows and columns
  count = 0; // set count to 0 after adding score
  
  // clear each full row
  // reset countRow array to 0
  for (int i=0 ; i<tenTenCharMatrix.numRows(); i++)
  {
   if(countRow[i]==1)
   {
    tenTenCharMatrix.clearRow(i);
    countRow[i]=0;
   }
  }
  
  // same for columns
  for(int i=0 ; i<tenTenCharMatrix.numCols(); i++)
  {
   if(countColumn[i]==1)
   {
    tenTenCharMatrix.clearColumn(i);
    countColumn[i]=0;
   }
  }

  score += piece.blockArea(piece.pieceShape);
 }
 
 public ScorePanel() //constructor
 	{
 	Box box = Box.createVerticalBox();
 	box.setPreferredSize(new Dimension(130,300));
 	JPanel p1 = new JPanel();
 	p1.setLayout(new GridLayout(2,2,10,10));
 	newGame = new JButton("New Game");
 	newGame.addActionListener(new NewGameListener());
 	p1.add(newGame);
 	help = new JButton("Help");
 	help.addActionListener(new HelpListener());
 	p1.add(new JLabel("Score:",null, JLabel.RIGHT));
	scorekeeper = new JTextField("100");
   	scorekeeper.setEditable(false);
 	box.add(p1);
	this.add(box); 	
 	}
	 
//public NewGameListener implements ActionListener
//{
//	public void actionPerformed(ActionEvent e)
//	{
//		score = 0;
//	   	tenTenCharMatrix.clear();
//	    	piecePanel.new();
//	}
//}

public void newGame(){
	
	score = 0;
	tenTenCharMatrix.clear();
	piecePanel = new PiecePanel();
}


public void update(int score) {
	scorekeeper.setText(String.format("%03d", score));
	
}

public void setScoreDisplay(ScoreDisplay display)
{
  scoreDisplay = display;
  scoreDisplay.update(score);
}


  

}
