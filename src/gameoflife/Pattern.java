package gameoflife;

import java.util.ArrayList;

public class Pattern {
	
	int centerX = 0, centerY = 0;
	Pattern(int centerX, int centerY) {
		this.centerX = centerX;
		this.centerY = centerY;
	}
	
		public ArrayList<Cell> getBlock(){
//			int x = getGridCenterX()
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(centerX-1,centerY-1,true));
			seed.add(new Cell(centerX-1,centerY,true));
			seed.add(new Cell(centerX,centerY-1,true));
			seed.add(new Cell(centerX,centerY,true));
			return seed;
		}
		
		public static ArrayList<Cell> getBeehive(){
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(7,6,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(6,8,true));
			seed.add(new Cell(7,9,true));
			seed.add(new Cell(8,7,true));
			seed.add(new Cell(8,8,true));
			return seed;
		}
		
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
		}
		
		public static ArrayList<Cell> getBoat() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(8,8,true));
			seed.add(new Cell(7,9,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(6,7,true));
			seed.add(new Cell(6,8,true));
			return seed;
		}
		
		public static ArrayList<Cell> getTub() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(8,6,true));
			seed.add(new Cell(9,7,true));
			seed.add(new Cell(8,8,true));
			seed.add(new Cell(7,7,true));
			return seed;
		}
	
	
		public static ArrayList<Cell> getBlinker() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(6,7,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(8,7,true));
			return seed;
		}
		

		public static ArrayList<Cell> getToad() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(8,6,true));
			seed.add(new Cell(8,7,true));
			seed.add(new Cell(8,8,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(7,8,true));
			seed.add(new Cell(7,9,true));
			return seed;
		}
		

		public static ArrayList<Cell> getBeacon() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			seed.add(new Cell(7,6,true));
			seed.add(new Cell(6,6,true));
			seed.add(new Cell(6,7,true));
			seed.add(new Cell(9,8,true));
			seed.add(new Cell(9,9,true));
			seed.add(new Cell(8,9,true));
			return seed;
		}
		

		public static ArrayList<Cell> getPulsar() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			return seed;
		}
		

		public static ArrayList<Cell> getPentadecathlon() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			return seed;
		}
	
		public static ArrayList<Cell> getGlider() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			return seed;
		}
		

		public static ArrayList<Cell> getLWSS() {
			ArrayList<Cell> seed = new ArrayList<Cell>();
			return seed;
		}
	
}
