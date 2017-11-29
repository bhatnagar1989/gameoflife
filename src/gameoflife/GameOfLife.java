package gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
	
	public ArrayList<Cell> currentGeneration;
	public ArrayList<Cell> nextGeneration;
	
	public GameOfLife() {
		currentGeneration = new ArrayList<Cell>();
		nextGeneration = new ArrayList<Cell>();
	}

	
	public ArrayList<Cell> evolve(ArrayList<Cell> seed) {
		this.currentGeneration = seed; // getting seed from the grid
		this.generatePointsOfInterest();
		checkRules();
		this.currentGeneration = this.nextGeneration;
		this.nextGeneration = new ArrayList<Cell>();
		return currentGeneration;
	}
	
	public void checkRules() {
		for(int i = 0; i < this.currentGeneration.size(); i++) {
			Cell cell = this.currentGeneration.get(i);
			
			cell.countAliveNeighbors(currentGeneration);
			
			if (!cell.isAlive() && cell.numberOfAliveNeighbors == 3) {
				this.nextGeneration.add(cell.reproduce());
			}
			else if(cell.isAlive() && cell.numberOfAliveNeighbors<2 && cell.numberOfAliveNeighbors >3) {
				cell.kill();
			}
			else if(cell.isAlive() && (cell.numberOfAliveNeighbors==2 || cell.numberOfAliveNeighbors==3)) {
				this.nextGeneration.add(cell.reproduce());
			}
		}
		
	}
	
	/*
	 * This function generatePointsOfInterest() takes the list of the current alive cells (currentGeneration)
	 * and creates a list of neighboring dead cells of every alive cell. 
	 * 
	 * */
	public void generatePointsOfInterest() {
		int total = this.currentGeneration.size();
		for (int c = 0; c < total; c++) {
			Cell cell = this.currentGeneration.get(c);
			
			for (int i=cell.getX()-1; i<=cell.getX()+1; i++) {
				for (int j = cell.getY()-1; j<=cell.getY()+1; j++) {
					if (i != cell.getX() || j != cell.getY()) {
						Cell dummy = new Cell(i,j,false);
						if (!isIncluded(dummy)) {
							this.currentGeneration.add(dummy);
						}
					}
				}
			}
		}
	}
	
	public boolean isIncluded(Cell c) {
		for (int k=0; k<this.currentGeneration.size() ; k++){
			if (c.getX() == currentGeneration.get(k).getX() && c.getY() == currentGeneration.get(k).getY()) {
				return true;
			}
		}
		return false;
	}
}
