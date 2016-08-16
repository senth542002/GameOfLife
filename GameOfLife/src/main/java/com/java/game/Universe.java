package com.java.game;

import java.util.ArrayList;
import java.util.List;

public class Universe {

	private Cell[][] grid;

	public Universe(Cell[][] grid) {
		this.grid = ModifiedGrid(grid);

	}

	public Cell[][] ModifiedGrid(Cell[][] grid) {
		Cell[][] newGrid = UniverseUtil.prepareTwoDimentionalUniverseOf(grid.length + 2, grid[0].length + 2, false);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				newGrid[i + 1][j + 1] = grid[i][j];
			}
		}
		return newGrid;
	}

	public Cell[][] applyRule() {
		Cell[][] newGrid = new Cell[grid.length][grid[0].length];
		Cell[][] modifiedGrid = ModifiedGrid(grid);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				List<Boolean> neighbouringCellsStatus = identifyNeighbourCells(modifiedGrid, i + 1, j + 1);
				newGrid[i][j] = grid[i][j].applyRules(neighbouringCellsStatus, i, j);
			}
		}
		return newGrid;
	}

	public List<Boolean> identifyNeighbourCells(Cell[][] grid, int i, int j) {
		List<Boolean> cellNeighboursState = new ArrayList<Boolean>();

		cellNeighboursState.add(grid[i][j + 1].isAlive());
		cellNeighboursState.add(grid[i + 1][j].isAlive());
		cellNeighboursState.add(grid[i + 1][j + 1].isAlive());
		cellNeighboursState.add(grid[i + 1][j - 1].isAlive());
		cellNeighboursState.add(grid[i][j - 1].isAlive());
		cellNeighboursState.add(grid[i - 1][j].isAlive());
		cellNeighboursState.add(grid[i - 1][j + 1].isAlive());
		cellNeighboursState.add(grid[i - 1][j - 1].isAlive());

		return cellNeighboursState;
	}

}
