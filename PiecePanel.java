import java.awt.GridLayout;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JLabel;

public class PiecePanel extends JPanel
{
  private Piece p1;
  private Piece p2;
  private Piece p3;

  PiecePanel(Piece piece1, Piece piece2, Piece piece3)
  {
    p1 = piece1.setRandomPiece();
    p2 = piece2.setRandomPiece();
    p3 = piece3.setRandomPiece();
    Box box = Box.createHorizontalBox();
    box.setPreferredSize(new Dimension(130, 300));
    JPanel pa1 = new JPanel();
    pa1.setLayout(new GridLayout(17,5,10,10));
    int length1=p1.getLength();
    int length2=p2.getLength();
    int length3=p3.getLength();
    pa1.add(p1);
    pa1.add(p2);
    pa1.add(p3);
  }
}
