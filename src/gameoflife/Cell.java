package gameoflife;

public class Cell {

	public int x;
	public int y;
	public boolean isAlive;
	public boolean newState;
	public int numberOfAliveNeighbors;

	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.isAlive = false;
		this.newState = false;
		this.numberOfAliveNeighbors = 0;
	}
	

	public int getX() {return this.x;}
	public int getY() {return this.y;}
	public boolean getCurrentState() {return this.isAlive;}
	public void kill() {this.newState = false;}
	public void reproduce() {this.newState = true;}
	public void countAliveNeighbors() {
		// TODO count the alive neighbors and place it inside this.numberOfAliveNeighbors
	}

}
