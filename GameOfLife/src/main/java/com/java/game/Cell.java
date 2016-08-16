package com.java.game;

import java.util.List;

public class Cell {
	private Boolean isAlive;

	public Boolean isAlive() {
		return isAlive;
	}

	public Cell(Boolean alive) {
		this.isAlive = alive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isAlive == null) ? 0 : isAlive.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (isAlive == null) {
			if (other.isAlive != null)
				return false;
		} else if (!isAlive.equals(other.isAlive))
			return false;
		return true;
	}

	public Cell applyRules(List<Boolean> neighbouringCellsStatus, int i, int j) {
		int numberOfNeighboursAlive = (int) neighbouringCellsStatus.stream().filter(x -> x.equals(true)).count();

		if (this.isAlive) {
			if (numberOfNeighboursAlive == 0) {
				return new Cell(true);
			} else if (numberOfNeighboursAlive < 2) {
				return new Cell(false);
			} else if (numberOfNeighboursAlive > 3) {
				return new Cell(false);
			} else {
				return new Cell(true);
			}
		} else {
			if (numberOfNeighboursAlive == 0) {
				return new Cell(false);
			} else if (numberOfNeighboursAlive == 3) {
				return new Cell(true);
			} else {
				return new Cell(false);
			}
		}
	}

}
