package com.java.game;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class GameOfLifeAndDeath {

	@Test
	public void SingleCellUniverse() throws Exception {
		Cell[][] grid = UniverseUtil.prepareTwoDimentionalUniverseOf(1, 1, true);
		Universe universe = new Universe(grid);
		Cell[][] gridStatus = universe.applyRule();
		assertArrayEquals(universe.ModifiedGrid(grid), gridStatus);
	}

	@Test
	public void TwoCellUniverseBlockPattern() throws Exception {
		Cell[][] grid = UniverseUtil.prepareTwoDimentionalUniverseOf(2, 2, true);
		Universe universe = new Universe(grid);
		Cell[][] gridStatus = universe.applyRule();
		assertArrayEquals(universe.ModifiedGrid(grid), gridStatus);
	}

	@Test
	public void ThreeCellUniverseBlinker() throws Exception {
		Cell[][] grid = UniverseUtil.prepareTwoDimentionalUniverseOf(3, 3, true);
		grid[0][0] = new Cell(false);
		grid[0][1] = new Cell(false);
		grid[0][2] = new Cell(false);
		grid[2][0] = new Cell(false);
		grid[2][1] = new Cell(false);
		grid[2][2] = new Cell(false);
		Universe universe = new Universe(grid);
		Cell[][] gridStatus = universe.applyRule();
		Cell[][] outputGrid = UniverseUtil.prepareTwoDimentionalUniverseOf(3, 3, false);
		outputGrid[0][1] = new Cell(true);
		outputGrid[1][1] = new Cell(true);
		outputGrid[2][1] = new Cell(true);
		assertArrayEquals(universe.ModifiedGrid(outputGrid), gridStatus);
	}

	@Test
	public void ThreeCellUniverseBoatPattern() throws Exception {
		Cell[][] grid = UniverseUtil.prepareTwoDimentionalUniverseOf(3, 3, true);
		grid[2][2] = new Cell(false);
		grid[1][1] = new Cell(false);
		grid[0][0] = new Cell(false);
		grid[2][0] = new Cell(false);
		Universe universe = new Universe(grid);
		Cell[][] gridStatus = universe.applyRule();
		assertArrayEquals(universe.ModifiedGrid(grid), gridStatus);
	}

	@Test
	public void universeToadPattern() throws Exception {
		Cell[][] grid = UniverseUtil.prepareTwoDimentionalUniverseOf(4, 2, true);
		grid[0][1] = new Cell(false);
		grid[3][0] = new Cell(false);

		Universe universe = new Universe(grid);
		Cell[][] gridStatus = universe.applyRule();

		Cell[][] outputGrid = UniverseUtil.prepareTwoDimentionalUniverseOf(6, 4, false);
		outputGrid[1][1] = new Cell(true);
		outputGrid[1][2] = new Cell(true);
		outputGrid[2][0] = new Cell(true);
		outputGrid[3][3] = new Cell(true);
		outputGrid[4][1] = new Cell(true);
		outputGrid[4][2] = new Cell(true);
		assertArrayEquals(outputGrid, gridStatus);

	}

}
