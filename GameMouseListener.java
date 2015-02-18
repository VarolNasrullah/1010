import java.awt.Label;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;


public class GameMouseListener implements MouseMotionListener, MouseListener {
	
	private int mX, mY;
	int startX = -1, startY = -1;/** starting location of a drag */
	int curX = -1, curY = -1;   /** current location of a drag */
	boolean inDrag = false;  /** true if we are in drag */
	static Label status; /** Kludge for showStatus */
	  
	  
	  
	  public GameMouseListener() {
		    addMouseMotionListener(this);
		    setVisible(true);
		  }

	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
	    System.err.println("mousePressed at " + p);
	    startX = p.x;
	    startY = p.y;
	    inDrag = true;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
	    curX = p.x;
	    curY = p.y;
	    if (inDrag) {
	      repaint();
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
		mX = (int) me.getPoint().getX();
	    mY = (int) me.getPoint().getY();
	    repaint();
		
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
	
	

}
