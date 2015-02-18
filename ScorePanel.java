import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ScorePanel extends JPanel{
 public int score; //variable that contains current score
 public int[] countRow = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
 public int[] countColumn = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
 public int count;
 TenTenCharMatrix apple = new TenTenCharMatrix(10,10); //make a TenTenCharMatrix class variable
 Piece apple2 = new Piece();
 
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
 
 public ScorePanel() //constructor
 	{
	 JButton newButton = new JButton("New Game"); //JButton with "New Game" written
	  //add actionListener to make JButton start a new game when pressed
	  class NewListener implements ActionListener 
	  {
	   public void actionPerformed(ActionEvent event)
	   {
	    score = 0;
	    apple.clear();
	    //apple3.new();
	   }
	  }
	  NewListener listener = new NewListener();
	  newButton.addActionListener(listener);

	  
	  
	  
	  //JTextField for displaying current score
	  JTextField scoreBoard = new JTextField(score);
	  scoreBoard.setFont(new Font("Serif", Font.BOLD, 35)); //set font for JTextField
	  
	  

	  
	        this.add(newButton); //add newButton to the scorePanel; instead of
	        					//adding it to the class "ScorePanel," add it to the
	        					//instances of ScorePanel.
	        this.add(scoreBoard); //add scoreBoard to the scorePanel
	 }
 
}
