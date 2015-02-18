import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box;

public class ScorePanel extends JPanel{
 public int score; //variable that contains current score
 public int[] countRow = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
 public int[] countColumn = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
 public int count;
 TenTenCharMatrix apple = new TenTenCharMatrix(10,10); //make a TenTenCharMatrix class variable
 Piece apple2 = new Piece();
 PiecePanel apple3 = new PiecePanel(apple2, apple2, apple2);
 private LetterPanel scorekeeper;
 private JButton newGame;
 
 //method for calculating current score
 //incomplete because there is no operation for 
 //adding scores for blocks placed in the matrix yet
 public void calculateScore()
 {
  // check which rows are full
  // add one to count for each full row
  for (int c=0; c<apple.numRows();c++)
  {
   if (apple.rowFull(c))
   {
    countRow[c]=1;
    count++;
   }
  }
  
  // same for columns
  for (int c=0; c<apple.numCols();c++)
  {
   if (apple.columnFull(c))
   {
    countColumn[c]=1;
    count++;
   }
  }
  score += 5*count*(count+1); // add score for all full rows and columns
  count = 0; // set count to 0 after adding score
  
  // clear each full row
  // reset countRow array to 0
  for (int i=0 ; i<apple.numRows(); i++)
  {
   if(countRow[i]==1)
   {
    apple.clearRow(i);
    countRow[i]=0;
   }
  }
  
  // same for columns
  for(int i=0 ; i<apple.numCols(); i++)
  {
   if(countColumn[i]==1)
   {
    apple.clearColumn(i);
    countColumn[i]=0;
   }
  }

  score += apple2.blockArea(apple2.pieceShape);
 }
 
 public ScorePanel(Letterpanel lpanel) //constructor
 	{
 	scorekeeper = lpanel;
 	Box box = Box.createVerticalBox();
 	box.setPreferredSize(new Dimension(130,300));
 	JPanel p1 = new JPanel();
 	p1.setLayout(new GridLayout(2,2,10,10));
 	newGame = new JButton("New Game");
 	newGame.addActionListener(new NewGameListener);
 	p1.add(newGame);
 	p1.add(new JPanel()); //creates an empty panel
 	p1.add(new JLabel("Score:",null, JLabel.RIGHT));
	scoreField = new JTextField("100");
   	scoreField.setEditable(false);
 	box.add(p1);
	this.add(box); 	
 	}
	 
public NewGameListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		score = 0;
	   	apple.clear();
	    	apple3.new();
	}
}

	  
	 
	 
 
}
