package com.java.game;

import java.util.ArrayList;
import java.util.List;

public class Universe {
	
	private Cell[][] grid;
	
	public Universe(Cell[][] grid) {
		this.grid = grid;
	}

	public Cell[][] applyRule() {
		Cell[][] newGrid = new Cell[grid.length][grid.length];
		for(int i=0; i< grid.length; i++) {
			for(int j=0; j< grid.length; j++){				
				newGrid[i][j] = grid[i][j].applyRules(grid, i, j);
			}
		}
		return newGrid;
	}

	
	
}
