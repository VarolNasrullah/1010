import java.awt.Color;
import java.util.Random;

	public class Piece {

	    protected enum PieceNames { NoShape, OneSquare, TwoUpright, TwoSideways, 
	               ThreeUpright, ThreeSideways, FourUpright, FourSideways, 
	               FiveUpright, FiveSideways, TwobyTwo, ThreebyThree, SmallLOne, 
	               SmallLTwo, SmallLThree, SmallLFour, BigLOne, BigLTwo, BigLThree,
	               BigLFour};

	    public PieceNames pieceShape;
	    private int coords[][];
	    public static int[][][] coordsTable;
	    private static int length;
	    public int[] lengthTable;
	    public Color[] possibleColors;
	    private Color color;
	    private char[] colorCases;
	    
	    public Piece() {

	        coords = new int[5][5];
	        setShape(PieceNames.NoShape);
	        
	         //assign chars to colors
	    }

	  
	   
	    
	    
	    public void setShape(PieceNames shape) {
	    	lengthTable = new int[] {0,1,2,2,3,3,4,4,5,5,4,9,3,3,3,3,5,5,5,5};
	    	possibleColors = new Color[] {Color.WHITE, Color.GRAY, Color.GREEN, 
	    			Color.GREEN, Color.BLUE, Color.BLUE, Color.MAGENTA, Color.MAGENTA, 
	    			Color.ORANGE, Color.ORANGE,Color.RED, Color.PINK, Color.YELLOW, 
	    			Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.CYAN,Color.CYAN,
	    			Color.CYAN,Color.CYAN};
	 //gray = z; Green = g; blue = b; magenta = m; orange = o; red = r; pink = p; yellow = y; cyan = c
	    	colorCases = new char[] {' ','w','g','g','b','b','m','m','o','o','r','p','y','y','y','y','c','c','c','c'};
	    	
	         coordsTable = new int[][][] {
	            { { 0, 0 } },
	            { { 0, 0 } },
	            { { 0, 0 },  { 0, 1 } },
	            { { 0, 0 },  { 1, 0 } },
	            { { 0, 0 },  { 0, 1 },   { 0, 2 } },
	            { { 0, 0 },   { 1, 0 },   { 2, 0 } },
	            { { 0, 0 }, { 0, 1 },  { 0, 2 },   { 0, 3 } },
	            { { 0, 0 },  { 1, 0 },  { 2, 0 },   { 3, 0 } },
	            { { 0, 0 },   { 0, 1 },   { 0, 2 },   { 0, 3 }, { 0, 4} },
	            { { 0, 0 },  { 1, 0 },   { 2, 0 },  { 3, 0 }, { 4, 0 } },
	            { { 0, 0 },  { 0, 1 },   { 1, 0 },   { 1, 1 } },
	            { { 0, 0 },  { 0, 1 },   { 0, 2 },   { 1, 0 }, {1, 1}, {1, 2}, {2,0}, {2,1}, {2,2} },
	            { { 0, 0 },  { 0, 1 },  { 1, 1 } },
	            { { 0, 0 },   { 0, -1 },   { -1, 0 } },
	            { { 0, 0 }, { 1, 0 },  { 1, 1 } },
	            { { 0, 0 },  { 1, 0 },  { 0, 1 } },
	            { { 0, 0 }, { 0, 1 },  { 0, 2 }, { 1, 0 }, { 2, 0 }},
	            { { 0, 0 }, { 0, 1 },  { 0, 2 },{ 1, 2 }, { 2, 2 } },
	            { { 0, 0 },  { 0, -1 },  { 0, -2 }, { -1,0 }, { -2,0 } },
	            { { 0, 0 },  { 1, 0 },  { 2, 0 },  { 2, 1 }, {2,2} }
	        };
	 
	       

	        for (int i = 0; i < 5 ; i++) {
	            
	            for (int j = 0; j < 5; ++j) {
	                
	            	
	                coords[i][j] = coordsTable[shape.ordinal()][i][j];
	                
	                
	            }
	        }
	       
	        
	        
	        length=lengthTable[shape.ordinal()];
	        
	        pieceShape = shape;
	        
	        color = possibleColors[shape.ordinal()];
	    }

	    public int blockArea(PieceNames piece){
	    	return length;
	    }
	    
	    public int[] getlengthTable(){
	    	return lengthTable;
	    }
	    
	    public int[][][] getcoordsTable(){
	    	return coordsTable;
	    }
	    
	    public int[][] getCoords(){
	    	return coords;
	    }
	    
	    public Color[] getpossibleColors(){
	    	return possibleColors;
	    }
	    
	    public Color getColor(){
	    	return color;
	    }
	    
	    public int getLength(){
	    	return length; 
	    }
	    
	
	    
	    
	    //private void setX(int index, int x) { coords[index][0] = x; }
	    //private void setY(int index, int y) { coords[index][1] = y; }
	    public int x(int index) { return coords[index][0]; }
	    public int y(int index) { return coords[index][1]; }
	    public PieceNames getShape()  { return pieceShape; }

	    public static Piece setRandomShape() {
	        
	    	Piece piece = new Piece();
	        Random r = new Random();
	        int x = Math.abs(r.nextInt()) % 7 + 1;
	        PieceNames[] values = PieceNames.values(); 
	        piece.setShape(values[x]);
	        return piece;
	    }
	    

	    public int minX() {
	        
	      int m = coords[0][0];
	      
	      for (int i=0; i < 10; i++) {
	          
	          m = Math.min(m, coords[i][0]);
	      }
	      
	      return m;
	    }


	    public int minY() {
	        
	      int m = coords[0][1];
	      
	      for (int i=0; i < 10; i++) {
	          
	          m = Math.min(m, coords[i][1]);
	      }
	      
	      return m;
	    }
	    
	  

	}
	

