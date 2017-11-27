package gameoflife;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
	
	public ArrayList<Cell> currentGeneration;
	public ArrayList<Cell> nextGeneration;
	
	
	public ArrayList<Cell> testGrid;
	
	
	
	public GameOfLife() {
		currentGeneration = new ArrayList<Cell>();
		nextGeneration = new ArrayList<Cell>();
		testGrid = new ArrayList<Cell>();
	}

//	public static void main(String[] args) {
//
//	    GameOfLife gol = new GameOfLife();
//	    gol.testGrid.add(new Cell(5,6,true));
//	    gol.testGrid.add(new Cell(6,6,true));
//	    gol.testGrid.add(new Cell(4,6,true));
//	    
//
//	    gol.testGrid.add(new Cell(12,11,true));
//	    gol.start();
//	    
//		
//	}

	
	public ArrayList<Cell> start(ArrayList<Cell> seed) {
		//System.out.println("Before Evolve");
		this.currentGeneration = seed; // getting seed from the grid
		
//		System.out.println("Generation "+this.tickCount);
//		for (int i=0; i<this.currentGeneration.size(); i++) {
//			Cell cell = this.currentGeneration.get(i);
//			System.out.println("["+cell.getX() + ","+cell.getY()+"]="+cell.isAlive());
//		}
		this.generatePointsOfInterest();
		evolve();
//		this.tickCount++;
		return currentGeneration;
	
	}
	
	public void stop() {
		
	}
	
	public void evolve() {
		for(int i = 0; i < this.currentGeneration.size(); i++) {
//			System.out.println("currGen i = [" + this.currentGeneration.get(i).getX() + "," + this.currentGeneration.get(i).getY() + "]=" + this.currentGeneration.get(i).isAlive);
			Cell cell = this.currentGeneration.get(i);
			
			cell.countAliveNeighbors(currentGeneration);
			//System.out.println("cellNeighbors["+cell.x+","+cell.y+"]="+cell.numberOfAliveNeighbors);
			
			if (!cell.isAlive && cell.numberOfAliveNeighbors == 3) {
				this.nextGeneration.add(cell.reproduce());
			}
			else if(cell.isAlive && cell.numberOfAliveNeighbors<2 && cell.numberOfAliveNeighbors >3) {
				cell.kill();
			}
			else if(cell.isAlive && (cell.numberOfAliveNeighbors==2 || cell.numberOfAliveNeighbors==3)) {
				this.nextGeneration.add(cell.reproduce());
			}
		}
//		System.out.println("Current Generation");
//		for (int i=0; i<this.currentGeneration.size(); i++) {
//			Cell cell = this.currentGeneration.get(i);
//			System.out.println("["+cell.getX() + ","+cell.getY()+"]="+cell.getCurrentState());
//		}
//
//		System.out.println("New Generation");
//		for (int i=0; i<this.nextGeneration.size(); i++) {
//			Cell cell = this.nextGeneration.get(i);
//			System.out.println("["+cell.getX() + ","+cell.getY()+"]="+cell.isAlive);
//		}
		
		this.currentGeneration = this.nextGeneration;
		this.nextGeneration = new ArrayList<Cell>();
	}
	
	public void generatePointsOfInterest() {
		int total = this.currentGeneration.size();
		for (int c = 0; c < total; c++) {

			//System.out.println(this.currentGeneration.size());
			Cell cell = this.currentGeneration.get(c);
			//System.out.println("finding neighbors for: ["+cell.getX() + ","+cell.getY()+"]");
			
			for (int i=cell.getX()-1; i<=cell.getX()+1; i++) {
				for (int j = cell.getY()-1; j<=cell.getY()+1; j++) {
					if (i != cell.getX() || j != cell.getY()) {
						Cell dummy = new Cell(i,j,false);
						//System.out.println("["+dummy.getX() + ","+dummy.getY()+"]");
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
