import java.awt.GridLayout;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JLabel;

public class PiecePanel extends JPanel
{
  public Piece p1;
  public Piece p2;
  public Piece p3;

  PiecePanel()
  {
    p1 = Piece.setRandomPiece();
    p2 = Piece.setRandomPiece();
    p3 = Piece.setRandomPiece();
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
    pa1.add(new GameMouseListener());
    box.add(pa1);
    this.add(box);
  }
