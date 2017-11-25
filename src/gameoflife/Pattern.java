package gameoflife;

import java.util.ArrayList;

public final class Pattern {
	
	protected static ArrayList<Cell> seed = new ArrayList<Cell>();
	
	
	public static class StillLifes{
		
		public static ArrayList<Cell> getBlock(){
//			int x = getGridCenterX()
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(7,8,true));
			seed.add(new Cell(8,7,true));
			seed.add(new Cell(8,8,true));
			return seed;
		}
		
		public static ArrayList<Cell> getBeehive(){
			seed.add(new Cell(7,6,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(6,8,true));
			seed.add(new Cell(7,9,true));
			seed.add(new Cell(8,7,true));
			seed.add(new Cell(8,8,true));
			return seed;
		}
		
		public static ArrayList<Cell> getLoaf() {
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
			seed.add(new Cell(8,8,true));
			seed.add(new Cell(7,9,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(6,7,true));
			seed.add(new Cell(6,8,true));
			return seed;
		}
		
		public static ArrayList<Cell> getTub() {
			seed.add(new Cell(8,6,true));
			seed.add(new Cell(9,7,true));
			seed.add(new Cell(8,8,true));
			seed.add(new Cell(7,7,true));
			return seed;
		}
	}
	
	public static class Oscillators{

		public static ArrayList<Cell> getBlinker() {
			seed.add(new Cell(6,7,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(8,7,true));
			return seed;
		}
		

		public static ArrayList<Cell> getToad() {
			seed.add(new Cell(8,6,true));
			seed.add(new Cell(8,7,true));
			seed.add(new Cell(8,8,true));
			seed.add(new Cell(7,7,true));
			seed.add(new Cell(7,8,true));
			seed.add(new Cell(7,9,true));
			return seed;
		}
		

		public static ArrayList<Cell> getBeacon() {
			seed.add(new Cell(7,6,true));
			seed.add(new Cell(6,6,true));
			seed.add(new Cell(6,7,true));
			seed.add(new Cell(9,8,true));
			seed.add(new Cell(9,9,true));
			seed.add(new Cell(8,9,true));
			return seed;
		}
		

		public static ArrayList<Cell> getPulsar() {
			return seed;
		}
		

		public static ArrayList<Cell> getPentadecathlon() {
			return seed;
		}
	}
	
	public static class Spaceships{
		

		public static ArrayList<Cell> getGlider() {
			return seed;
		}
		

		public static ArrayList<Cell> getLWSS() {
			return seed;
		}
	}
	
}
