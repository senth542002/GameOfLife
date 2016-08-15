package com.java.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Cell 
{
	private Boolean isAlive;

	public Boolean isAlive() {
		return isAlive;
	}

	public Cell(Boolean alive) {
		this.isAlive = alive;
	}
	
	public List<Boolean> identifyNeighbourCells(Cell[][] grid, int i , int j) {
		List<Boolean> cellNeighboursState = new ArrayList<Boolean>();

		System.out.println("Neighbours for the Cell "+i+","+j);
		if(j< grid.length -1 ){
			System.out.println("NothNeighbour Value"+grid[i][j+1].isAlive());
			cellNeighboursState.add(grid[i][j+1].isAlive());
		}
		if(i < grid.length -1){
			System.out.println("EastNeighbour Value"+grid[i+1][j].isAlive());
			cellNeighboursState.add(grid[i+1][j].isAlive());
		}
		if(i < grid.length-1 && j< grid.length-1 ){
			
			System.out.println("NorthEastNeighbour Value"+grid[i+1][j+1].isAlive());
			cellNeighboursState.add(grid[i+1][j+1].isAlive());
		}
		
		if(j>0){
			if(i < grid.length-1){						
				System.out.println("SouthEastNeighbour Value"+grid[i+1][j-1].isAlive());
				cellNeighboursState.add(grid[i+1][j-1].isAlive());
			}
			System.out.println("SouthNeighbour Value"+grid[i][j-1].isAlive());
			cellNeighboursState.add(grid[i][j-1].isAlive());
		}
		if(i>0){
			System.out.println("WestNeighbour Value"+grid[i-1][j].isAlive());
			cellNeighboursState.add(grid[i-1][j].isAlive());
			if(j < grid.length-1) {						
				System.out.println("NorthWestNeighbour Value"+grid[i-1][j+1].isAlive());
				cellNeighboursState.add(grid[i-1][j+1].isAlive());
			}
		}
		if(i>0 && j>0){					
			System.out.println("SouthWestNeighbour Value"+grid[i-1][j-1].isAlive());
			cellNeighboursState.add(grid[i-1][j-1].isAlive());
		}
		return cellNeighboursState;
}

	public Cell applyRules(Cell[][] grid, int i, int j) {
		List<Boolean> cellNeighboursState = identifyNeighbourCells(grid,i,j);
		int numberOfNeighboursAlive = (int) cellNeighboursState.stream().filter(x -> x.equals(true)).count();
		if(this.isAlive){
			
			if(numberOfNeighboursAlive < 2)
			{
				return new Cell(false);
			}else if (numberOfNeighboursAlive > 3){
				return new Cell(false);
			}else {
				return new Cell(true);
			}
		}
		else{
			if(numberOfNeighboursAlive == 3){
				return new Cell(true);
			}
			else{
				return new Cell(false);
			}
		}
	}
	
	
}
