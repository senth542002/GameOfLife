package com.java.dojo.CyberDojo;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

public class HikingTheDoors {

	@Test
	public void hikerVisitsAllTheDoors() {
		HikerGame hikerGame = new HikerGame();
		Map<Integer,Boolean> doors = hikerGame.startThePasses();
		boolean allDoorsOpen = isAllDoorsOpen(doors);
		assertTrue(allDoorsOpen);
	}
	
	@Test
	public void hikerVisitsAlternateDoors() throws Exception {
		HikerGame hikerGame = new HikerGame();
		Map<Integer,Boolean> doors = hikerGame.startThePasses();
		boolean alternateDoorsOpen = isDoorsClossedForSecondPass(doors);
		assertTrue(alternateDoorsOpen);
	}

	private boolean isDoorsClossedForSecondPass(Map<Integer, Boolean> doors) {
		for(int i=0; i< doors.size(); i+=2){
			if(doors.get(i).equals(false))
			return false;
		}
		return true;
	}

	private boolean isAllDoorsOpen(Map<Integer, Boolean> doors) {
		return !doors.containsValue(false);
	}

}
