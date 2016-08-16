package com.java.game;

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


	public Cell applyRules(List<Boolean> neighbouringCellsStatus, int i, int j) {
		int numberOfNeighboursAlive = (int) neighbouringCellsStatus.stream().filter(x -> x.equals(true)).count();
		
		if(this.isAlive){
			if(numberOfNeighboursAlive == 0){
				return new Cell(true);
			}
			else if(numberOfNeighboursAlive < 2)
			{
				return new Cell(false);
			} else if (numberOfNeighboursAlive > 3){
				return new Cell(false);
			} else {
				return new Cell(true);
			}
		}
		else{
			if(numberOfNeighboursAlive == 0){
				return new Cell(false);
			}
			else if(numberOfNeighboursAlive == 3){
				return new Cell(true);
			}
			else{
				return new Cell(false);
			}
		}
	}
	
	
}
