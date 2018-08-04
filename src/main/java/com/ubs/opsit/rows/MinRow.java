package com.ubs.opsit.rows;

import java.util.Arrays;

import com.ubs.opsit.util.BerlinClockUtil;

public class MinRow implements BerlinClock {

	@Override
	public String parseTime(int mm) {
		if(mm < 0) {
			throw new RuntimeException("Invalid argument");
		}
		String fourthRow = BerlinClockUtil.displayLamp(mm / 5, 11,BerlinClockUtil.COLOR_Y, Arrays.asList(3,6,9));
		String fifthRow = BerlinClockUtil.displayLamp(mm % 5, 4,BerlinClockUtil.COLOR_Y,null);
		return fourthRow + BerlinClockUtil.NEXTLINE+ fifthRow;
	}

}
