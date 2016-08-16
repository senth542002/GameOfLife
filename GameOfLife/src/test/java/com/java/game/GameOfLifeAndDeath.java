package com.java.game;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameOfLifeAndDeath 
{
	public Cell[][] prepareTwoDimentionalUniverseOf(int x,int y, boolean aliveOrDead) {
		Cell[][] grid = new Cell[x][y];
		for(int i=0; i< grid.length; i++ ){
			for(int j=0; j<grid.length; j++) {
				grid[i][j] = new Cell(aliveOrDead);
			}
		}
		return grid;
	}
	
    @Test
	public void SingleCellUniverse() throws Exception {
    	Cell[][] grid = prepareTwoDimentionalUniverseOf(1,1, true);
		Universe universe = new Universe(grid);
		Cell[][] gridStatus = universe.applyRule();
		assertTrue(true==gridStatus[0][0].isAlive());
	}

    
    @Test
	public void TwoCellUniverseBoat() throws Exception {
    	Cell[][] grid = prepareTwoDimentionalUniverseOf(2,2, true);
    	Universe universe = new Universe(grid);
		Cell[][] gridStatus = universe.applyRule();
		assertTrue(true==gridStatus[0][0].isAlive());
		assertTrue(true==gridStatus[0][1].isAlive());
		assertTrue(true==gridStatus[1][0].isAlive());
		assertTrue(true==gridStatus[1][1].isAlive());
	}
    
    @Test
	public void ThreeCellUniverseBlinker() throws Exception {
    	Cell[][] grid = prepareTwoDimentionalUniverseOf(3,3, true);
    	grid[0][0] = new Cell(false);
    	grid[0][1] = new Cell(false);
    	grid[0][2] = new Cell(false);
    	grid[2][0] = new Cell(false);
    	grid[2][1] = new Cell(false);
    	grid[2][2] = new Cell(false);
    	Universe universe = new Universe(grid);
		Cell[][] gridStatus = universe.applyRule();
		assertTrue(false==gridStatus[0][0].isAlive());
		assertTrue(true==gridStatus[0][1].isAlive());
		assertTrue(false==gridStatus[0][2].isAlive());
		assertTrue(false==gridStatus[1][0].isAlive());
		assertTrue(true==gridStatus[1][1].isAlive());
		assertTrue(false==gridStatus[1][2].isAlive());
		assertTrue(false==gridStatus[2][0].isAlive());
		assertTrue(true==gridStatus[2][1].isAlive());
		assertTrue(false==gridStatus[2][2].isAlive());
	}
    
    @Test
   	public void ThreeCellUniverse() throws Exception {
       	Cell[][] grid = prepareTwoDimentionalUniverseOf(3,3, true);
       	grid[2][2] = new Cell(false);
       	grid[1][1] = new Cell(false);
       	grid[0][0] = new Cell(false);
       	grid[2][0] = new Cell(false);
       	Universe universe = new Universe(grid);
   		Cell[][] gridStatus = universe.applyRule();
   		assertTrue(false==gridStatus[0][0].isAlive());
   		assertTrue(true==gridStatus[0][1].isAlive());
   		assertTrue(true==gridStatus[0][2].isAlive());
   		assertTrue(true==gridStatus[1][0].isAlive());
   		assertTrue(false==gridStatus[1][1].isAlive());
   		assertTrue(true==gridStatus[1][2].isAlive());
   		assertTrue(false==gridStatus[2][0].isAlive());
   		assertTrue(true==gridStatus[2][1].isAlive());
   		assertTrue(false==gridStatus[2][2].isAlive());
   	}
    
    @Test
   	public void FiveCellUniverse() throws Exception {
       	Cell[][] grid = prepareTwoDimentionalUniverseOf(5,5, false);
       	grid[1][1] = new Cell(true);
       	grid[2][1] = new Cell(true);
       	grid[3][1] = new Cell(true);
       	grid[2][2] = new Cell(true);
       	grid[3][2] = new Cell(true);
       	grid[4][2] = new Cell(true);
       	Universe universe = new Universe(grid);
   		Cell[][] gridStatus = universe.applyRule();
   		assertTrue(false==gridStatus[1][0].isAlive());
   		assertTrue(true==gridStatus[2][0].isAlive());
   		assertTrue(false==gridStatus[3][0].isAlive());
   		assertTrue(false==gridStatus[4][0].isAlive());
   		assertTrue(true==gridStatus[1][1].isAlive());
   		assertTrue(false==gridStatus[2][1].isAlive());
   		assertTrue(false==gridStatus[3][1].isAlive());
   		assertTrue(true==gridStatus[4][1].isAlive());
   		assertTrue(true==gridStatus[1][2].isAlive());
   		assertTrue(false==gridStatus[2][2].isAlive());
   		assertTrue(false==gridStatus[3][2].isAlive());
   		assertTrue(true==gridStatus[4][2].isAlive());
   		assertTrue(false==gridStatus[1][3].isAlive());
   		assertTrue(false==gridStatus[2][3].isAlive());
   		assertTrue(true==gridStatus[3][3].isAlive());
   		assertTrue(false==gridStatus[4][3].isAlive());
   	}
    
   /* @Test
	public void identifiesNeighbouringCellValuesForTwoByTwoUniverse() throws Exception {
    	Cell[][] grid = prepareTwoDimentionalUniverseOf(1,1);
    	Universe universe = new Universe(grid);
    	universe.identifyNeighbourCells(grid,1,1);
	}*/
    
}
