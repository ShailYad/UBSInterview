package com.ubs.opsit.rows;

import com.ubs.opsit.util.BerlinClockUtil;

public class HourRowRed implements BerlinClock {
	
	@Override
	public String parseTime(int hh) {
		if(hh < 0) {
			throw new RuntimeException("Invalid argument");
		}
		String secRow =  BerlinClockUtil.displayLamp(hh/5, 4, BerlinClockUtil.COLOR_R,null);
		String thirdrow  = BerlinClockUtil.displayLamp(hh%5, 4,BerlinClockUtil.COLOR_R, null);
	 	return secRow+BerlinClockUtil.NEXTLINE+thirdrow;
	}

	
		 
}
