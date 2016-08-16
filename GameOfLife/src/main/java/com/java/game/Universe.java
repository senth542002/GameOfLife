package com.java.game;

import java.util.ArrayList;
import java.util.List;

public class Universe {
	
	private Cell[][] grid;
	
	public Universe(Cell[][] grid) {
		ModifiedGrid(grid);
		
	}

	public Cell[][] ModifiedGrid(Cell[][] grid) {
		this.grid = UniverseUtil.prepareTwoDimentionalUniverseOf(grid.length+2, grid[0].length+2, false);
		for(int i=0; i< grid.length; i++){
			for(int j=0; j< grid[0].length; j++){
				this.grid[i+1][j+1] = grid[i][j];
			}
		}
		return this.grid;
	}

	public Cell[][] applyRule() {
		Cell[][] newGrid = new Cell[grid.length][grid[0].length];
		for(int i=0; i< grid.length; i++) {
			for(int j=0; j< grid[0].length; j++){	
				List<Boolean> neighbouringCellsStatus = identifyNeighbourCells(grid, i, j);
				newGrid[i][j] = grid[i][j].applyRules(neighbouringCellsStatus, i, j);
			}
		}
		return newGrid;
	}

	public List<Boolean> identifyNeighbourCells(Cell[][] grid, int i , int j) {
		List<Boolean> cellNeighboursState = new ArrayList<Boolean>();

		System.out.println("Neighbours for the Cell "+i+","+j);
		if(j< grid[0].length -1 ){
			System.out.println("NothNeighbour Value"+grid[i][j+1].isAlive());
			cellNeighboursState.add(grid[i][j+1].isAlive());
		}
		if(i < grid.length -1){
			System.out.println("EastNeighbour Value"+grid[i+1][j].isAlive());
			cellNeighboursState.add(grid[i+1][j].isAlive());
		}
		if(i < grid.length-1 && j< grid[0].length-1 ){
			
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
			if(j < grid[0].length-1) {						
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
	
	
}
