//package com.zetcode;
	//http://zetcode.com/tutorials/javaswingtutorial/thetetrisgame/

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
	    private int[][][] coordsTable;
	    private int length;
	    private int[] lengthTable;
	    private Color[] possibleColors;

	    public Piece() {

	        coords = new int[5][5];
	        setShape(PieceNames.NoShape);
	    }

	    public void setShape(PieceNames shape) {
	    	lengthTable = new int[] {0,1,2,2,3,3,4,4,5,5,4,9,3,3,3,3,5,5,5,5};
	    	possibleColors = new Color[] {Color.WHITE, Color.GRAY, Color.GREEN, 
	    			Color.GREEN, Color.BLUE, Color.BLUE, Color.MAGENTA, Color.MAGENTA, 
	    			Color.ORANGE, Color.ORANGE,Color.RED, Color.PINK, Color.YELLOW, 
	    			Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.CYAN,Color.CYAN,
	    			Color.CYAN,Color.CYAN};
	 

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
	            { { 0, 1 },   { 1, 1 },   { 1, 0 } },
	            { { 0, 0 }, { 1, 0 },  { 1, 1 } },
	            { { 0, 0 },  { 1, 0 },  { 0, 1 } },
	            { { 0, 0 }, { 0, 1 },  { 0, 2 }, { 1, 0 }, { 2, 0 }},
	            { { 0, 0 }, { 0, 1 },  { 0, 2 },{ 1, 2 }, { 2, 2 } },
	            { { 0, 2 },  { 1, 2 },  { 2, 2 }, { 2,1 }, { 2,0 } },
	            { { 0, 0 },  { 1, 0 },  { 2, 0 },  { 2, 1 }, {2,2} }
	        };
	 
	       

	        for (int i = 0; i < 4 ; i++) {
	            
	            for (int j = 0; j < 2; ++j) {
	                
	                coords[i][j] = coordsTable[shape.ordinal()][i][j];
	            }
	        }
	       
	        
	        
	        length=lengthTable[shape.ordinal()];
	        
	        pieceShape = shape;
	    }

	    public int blockArea(PieceNames piece){
	    	return length;
	    }
	    
	    public int getLength(PieceNames piece){
	    	return length; 
	    }
	    
	
	    
	    
	    //private void setX(int index, int x) { coords[index][0] = x; }
	    //private void setY(int index, int y) { coords[index][1] = y; }
	    public int x(int index) { return coords[index][0]; }
	    public int y(int index) { return coords[index][1]; }
	    public PieceNames getShape()  { return pieceShape; }

	    public void setRandomShape() {
	        
	        Random r = new Random();
	        int x = Math.abs(r.nextInt()) % 7 + 1;
	        PieceNames[] values = PieceNames.values(); 
	        setShape(values[x]);
	    }
	    

	    public int minX() {
	        
	      int m = coords[0][0];
	      
	      for (int i=0; i < 4; i++) {
	          
	          m = Math.min(m, coords[i][0]);
	      }
	      
	      return m;
	    }


	    public int minY() {
	        
	      int m = coords[0][1];
	      
	      for (int i=0; i < 4; i++) {
	          
	          m = Math.min(m, coords[i][1]);
	      }
	      
	      return m;
	    }
	    
	  

	}
	

