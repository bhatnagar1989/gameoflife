package gameoflife;

import java.util.ArrayList;

public class Cell {

	public int x;
	public int y;
	public boolean isAlive=false;
	//public boolean newState=false;
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
	

	public int getX() {return this.x;}
	public int getY() {return this.y;}
	public boolean isAlive() {return this.isAlive;}
	public Cell kill() {return new Cell(x,y,false);}
	public Cell reproduce() {return new Cell(x,y,true);}
	public void countAliveNeighbors(ArrayList<Cell> currentGen) {
		// TODO count the alive neighbors and place it inside this.numberOfAliveNeighbors
		for (int k=0; k<currentGen.size(); k++) {
			Cell cell = currentGen.get(k);
			if (cell.getX()>=x-1 && cell.getX()<=x+1 && cell.getY()>=y-1 && cell.getY()<=y+1) {
				if (cell.getX() != this.x || cell.getY() != this.y) {
					if (cell.isAlive()) {
						this.numberOfAliveNeighbors++;
					}
				}
			}
		}
		//System.out.println("["+x+","+y+"] neighbors = "+this.numberOfAliveNeighbors);
	}

}
