/**
* The Pattern class is a subset of Grid. It contains predefined
* patterns of Game of Life. A pattern is predefined using the 
* X and Y coordinates on the grid. A pattern get populated on the 
* grid once called using the drop down list in the UI Frame.
*
* @author  Pranav and Kostas
* @version 1.0
* @since   2017-11-29 
*/

package gameoflife;

import java.util.ArrayList;

public class Pattern {
	
	int centerX = 0, centerY = 0;
	Pattern(int centerX, int centerY) {
		this.centerX = centerX; //center of X (rows)
		this.centerY = centerY; //center of X (columns)
	}
	
		public ArrayList<Cell> getBlock(){
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(centerX-1,centerY-1,true));
			seed.add(new Cell(centerX-1,centerY,true));
			seed.add(new Cell(centerX,centerY-1,true));
			seed.add(new Cell(centerX,centerY,true));
			return seed;
		}//end getBlock
		
		public ArrayList<Cell> getBeehive(){
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(centerX-1,centerY-2,true));
			seed.add(new Cell(centerX-2,centerY-1,true));
			seed.add(new Cell(centerX-2,centerY,true));
			seed.add(new Cell(centerX-1,centerY+1,true));
			seed.add(new Cell(centerX,centerY-1,true));
			seed.add(new Cell(centerX,centerY,true));
			return seed;
		}//end getBeehive
		
		public static ArrayList<Cell> getLoaf() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(7,6,true));
			seed.add(new Cell(9,8,true));
			seed.add(new Cell(8,7,true));
			seed.add(new Cell(6,7,true));
			seed.add(new Cell(6,8,true));
			seed.add(new Cell(7,9,true));
			seed.add(new Cell(8,9,true));
			return seed;
		}//end getLoaf
		
		public static ArrayList<Cell> getBoat() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(8,8,true));
			seed.add(new Cell(7,9,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(6,7,true));
			seed.add(new Cell(6,8,true));
			return seed;
		}//end getBoat
		
		public static ArrayList<Cell> getTub() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(8,6,true));
			seed.add(new Cell(9,7,true));
			seed.add(new Cell(8,8,true));
			seed.add(new Cell(7,7,true));
			return seed;
		}//end getTub
	
	
		public static ArrayList<Cell> getBlinker() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(6,7,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(8,7,true));
			return seed;
		}//end getBlinker
		

		public static ArrayList<Cell> getToad() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(8,6,true));
			seed.add(new Cell(8,7,true));
			seed.add(new Cell(8,8,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(7,8,true));
			seed.add(new Cell(7,9,true));
			return seed;
		}//end getToad
		

		public static ArrayList<Cell> getBeacon() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(7,6,true));
			seed.add(new Cell(6,6,true));
			seed.add(new Cell(6,7,true));
			seed.add(new Cell(9,8,true));
			seed.add(new Cell(9,9,true));
			seed.add(new Cell(8,9,true));
			return seed;
		}//end getBeacon
		

		public ArrayList<Cell> getPentadecathlon() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(centerX,centerY-5,true));
			seed.add(new Cell(centerX,centerY-4,true));
			seed.add(new Cell(centerX-1,centerY-3,true));
			seed.add(new Cell(centerX+1,centerY-3,true));
			seed.add(new Cell(centerX,centerY-2,true));
			seed.add(new Cell(centerX,centerY-1,true));
			seed.add(new Cell(centerX,centerY,true));
			seed.add(new Cell(centerX,centerY+1,true));
			seed.add(new Cell(centerX-1,centerY+2,true));
			seed.add(new Cell(centerX+1,centerY+2,true));
			seed.add(new Cell(centerX,centerY+3,true));
			seed.add(new Cell(centerX,centerY+4,true));
			return seed;
		}//end getPentadecathlon
	
		public  ArrayList<Cell> getGlider() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(centerX,centerY,true));
			seed.add(new Cell(centerX+1,centerY,true));
			seed.add(new Cell(centerX-1,centerY,true));
			seed.add(new Cell(centerX,centerY-2,true));
			seed.add(new Cell(centerX+1,centerY-1,true));
			return seed;
		}//end getGlider
		

		public ArrayList<Cell> getLWSS() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(centerX,centerY,true));
			seed.add(new Cell(centerX,centerY-2,true));
			seed.add(new Cell(centerX+1,centerY-3,true));
			seed.add(new Cell(centerX+2,centerY-3,true));
			seed.add(new Cell(centerX+3,centerY-3,true));
			seed.add(new Cell(centerX+4,centerY-3,true));
			seed.add(new Cell(centerX+4,centerY-2,true));
			seed.add(new Cell(centerX+4,centerY-1,true));
			seed.add(new Cell(centerX+3,centerY,true));
			return seed;
		}//end getLWSS
}//end class..
