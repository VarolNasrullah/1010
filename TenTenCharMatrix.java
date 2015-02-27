import java.awt.Color;

/**
 * @author Yong, Sonja, Ben B. , Dr. Bardoe
 * Represents a 2-D array of characters for TenTen
 * SPACE = empty
 * b=Blue
 * r=Red
 * ...
 */
public class TenTenCharMatrix
{
  public final char SPACE = ' ';
  private char[][] grid;

  // Constructor: creates a grid with dimensions rows, cols,
  // and fills it with spaces
  public TenTenCharMatrix(int rows, int cols)
  {
    grid = new char[rows][cols];
    clear();
  }

  // Returns the number of rows in grid
  public int numRows()
  {
    return grid.length;
  }

  // Returns the number of columns in grid
  public int numCols()
  {
    return grid[0].length;
  }

  // Returns the character at row, col location
  public char charAt(int row, int col)
  {
    return grid[row][col];
  }

  // Sets the character at row, col location to ch
  public void setCharAt(int row, int col, char ch)
  {
    grid[row][col] = ch;
  }

  // Returns true if the character at row, col is a space,
  // false otherwise
  public boolean isEmpty(int row, int col)
  {
    return charAt(row, col) == SPACE;
  }

  // Fills the grid with SPACE characters. Use when we want to erase whole 10x10 grid
  public void clear()
  {
    for (int r = 0; r < numRows(); r++)
    {
      for (int c = 0; c < numCols(); c++)
      {
        setCharAt(r, c, SPACE);
      }
    }
  }

  /**
   * These functions return true/false depending on whether all 10 tiles are full
   */
  public boolean rowFull(int row)
  {
	  
	  for (int c=0; c<this.numCols();c++)
	  {
		  if (this.isEmpty(row,c))
		  {
			  return false;
		  }
	  }
	  return true;
  }
  
  public boolean columnFull(int column) 
  {
	  for(int r = 0 ; r<this.numRows();r++)
	  {
		  if(this.isEmpty(r, column))
		  {
			  return false;
		  }
	  }
	  return true;
  }
  /**
   * These functions empties the row.
   * @param row
   */
  public void clearRow(int row)
  {
	  
	      for (int c = 0; c < numCols(); c++)
	      {
	        setCharAt( row,c, SPACE);
	      }
  }
  public void clearColumn(int column)
  {
	  for (int r = 0; r < numRows(); r++)
	    {
	      
	        setCharAt(r, column, SPACE);
	     
	    }
  }
  public String toString()
  {
	  String ans="";
	  for (int r = 0; r < numRows(); r++)
	    {
	      for (int c = 0; c < numCols(); c++)
	      {
	        ans+=grid[r][c]+" ";
	      }
	      ans+="\n";
	    }
	  return ans;
  }
  public static void main(String[] args)
  {
	  
  }
}
