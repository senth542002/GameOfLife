package com.java.dojo.CyberDojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HikerGame {
	
	Map<Integer, Boolean> doors;
	
	public HikerGame() {
		this.doors = new HashMap<Integer, Boolean>(100);  
		for(int i=0; i < 100; i++) {
			this.doors.put(i, false);
		}
	}

	public Map<Integer, Boolean> startThePasses() {
		/*for(int i=0 ; i<100; i+=1){
			doors.put(i, false);
		}
		for(int i=1 ; i<=100; i+=2){
			doors.put(i, false);
		}*/
		
		for(int j=1; j<=100; j++){
			for(int i=j-1 ; i<100; i+=j){
				if(i/2 == 0){
					doors.put(i, true);
				}
				else{
					doors.put(i, false);
				}
			}
		}
		return doors;
	}
	
	

}
