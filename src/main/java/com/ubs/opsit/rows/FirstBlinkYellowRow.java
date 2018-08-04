package com.ubs.opsit.rows;

public class FirstBlinkYellowRow implements BerlinClock {
	
	
	@Override
	public String parseTime(int ss) {
		if(ss < 0) {
			throw new RuntimeException("Invalid argument");
		}
		if(ss % 2 == 0) {
		 	return "Y";
		}
		return "O";
	}

}
