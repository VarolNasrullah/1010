import java.awt.GridLayout;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JLabel;

public class PiecePanel extends JPanel
{
  public PieceSelector p1;
  public PieceSelector p2;
  public PieceSelector p3;

  PiecePanel()
  {
	Box box1 = Box.createHorizontalBox();
    box1.setPreferredSize(new Dimension(130, 300));
    JPanel pa1 = new JPanel();
    pa1.setLayout(new GridLayout(17,5,10,10));
    pa1.add(p1);
    pa1.add(p2);
    pa1.add(p3);
    pa1.add(new GameMouseListener());
    box.add(pa1);
    this.add(box);
  }
}

public void setGridMouseX(int gridMouseX) {
this.gridMouseX = gridMouseX;
}

public void setGridMouseY(int gridMouseY){
this.gridMouseY = gridMouseY;
}
