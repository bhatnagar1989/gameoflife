package gameoflife;

import java.util.ArrayList;

public class Cell {

	private int x;
	private int y;
	public boolean isAlive=false; //set the default state of the cell to false
	public int numberOfAliveNeighbors=0;

	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Cell(int x, int y, boolean isAlive) {
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}
	
	//Declaring public variables
	public int getX() {return this.x;}
	public int getY() {return this.y;}
	public boolean isAlive() {return this.isAlive;}
	public Cell kill() {return new Cell(x,y,false);} //to change cell state to false
	public Cell reproduce() {return new Cell(x,y,true);} //to change cell state to true
	
	
	/*
	** countAliveNeighbors() count the number of Alive neighbours by checking around the cell
	** in consideration. This is required to imply the rules of the games i.e. to kill, die or to 
	** make the fourth cell alive
	*/
	
	public void countAliveNeighbors(ArrayList<Cell> currentGen) {
		for (int k=0; k<currentGen.size(); k++) {
			Cell cell = currentGen.get(k);
			if (cell.getX()>=x-1 && cell.getX()<=x+1 && cell.getY()>=y-1 && cell.getY()<=y+1) {
				if (cell.getX() != this.x || cell.getY() != this.y) {
					if (cell.isAlive()) {
						this.numberOfAliveNeighbors++;
					}//end if..
				}//end if..
			}//end if..
		}//end for k
	}//end countAliveNeighbors

}//end class
