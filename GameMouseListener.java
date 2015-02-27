import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GameMouseListener implements MouseMotionListener, MouseListener {
	
	private PiecePanel piecePanel;
	private GamePanel gPanel;
	private ScorePanel scorePanel;
	static JTextField text = new JTextField();

	
	private int mX, mY;
	int startX = -1, startY = -1;/** starting location of a drag */
	int curX = -1, curY = -1;   /** current location of a drag */
	boolean inDrag = false;  /** true if we are in drag */
	static Label status; /** Kludge for showStatus */
	  
	  
	  public GameMouseListener(GamePanel gPanel)
	  {
		  this.gPanel = gPanel;
	  }
	  public GameMouseListener(PiecePanel piecePanel, ScorePanel scorePanel) {
		   this.piecePanel = piecePanel;
		   this.scorePanel = scorePanel;
		  }

	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
	    System.err.println("mousePressed at " + p);
	    startX = p.x/40;
	    startY = p.y/40;
	    inDrag = true;
	    System.out.println(startX+", "+startY);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
	    curX = p.x;
	    curY = p.y;
	    if (inDrag) {
	      frame.repaint();
	      //maybe repaint has to happen in another method, where the 
	      //listener is added 
	    }
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		inDrag = false;
	    System.err.println("SELECTION IS " + startX + "," + startY + " to "
	        + curX + "," + curY);	
	}
	
	@Override
	public void mouseMoved(MouseEvent me) {
		mX = (int) me.getPoint().getX()/40;
	    mY = (int) me.getPoint().getY()/40;
	    gPanel.setGridMouseX(mX);
	    gPanel.setGridMouseY(mY);
		
	}
	
	public void showStatus(String s) {
	    status.setText(s);
	  }
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	     JFrame frame = new JFrame("Click Counter");
	    public  void frame(){
	        Font f = new Font("Engravers MT", Font.BOLD, 23);
	        text.setEditable(false);
	        text.setBackground(Color.BLUE);
	        text.setFont(f);
	        text.setForeground(Color.GREEN);
	        text.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	    
	        frame.add(text, BorderLayout.SOUTH);
	        frame.setResizable(false);
	        frame.setSize(300, 300);
	        frame.getContentPane().setBackground(Color.BLUE);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        frame.addMouseListener(this);
	    }
	
	
	public static void main(String[] args){
		GameMouseListener gml=new GameMouseListener();
		gml.frame();
	}
	

}
