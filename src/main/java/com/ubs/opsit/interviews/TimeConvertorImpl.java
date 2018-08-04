package com.ubs.opsit.interviews;

import com.ubs.opsit.rows.FirstBlinkYellowRow;
import com.ubs.opsit.rows.HourRowRed;
import com.ubs.opsit.rows.MinRow;
import com.ubs.opsit.util.BerlinClockUtil;

public class TimeConvertorImpl implements TimeConverter {
	
	FirstBlinkYellowRow firstRow = new FirstBlinkYellowRow();
	HourRowRed hrRows = new HourRowRed();
	MinRow minRows = new MinRow();

	@Override
	public String convertTime(String aTime) {
		String[] aTimeArr = aTime.split(":");
		if(aTimeArr.length == 3) {
		int hour = Integer.parseInt(aTimeArr[0]);
		int min = Integer.parseInt(aTimeArr[1]);
		int sec = Integer.parseInt(aTimeArr[2]);
		return firstRow.parseTime(sec) + BerlinClockUtil.NEXTLINE + hrRows.parseTime(hour) + BerlinClockUtil.NEXTLINE
				+ minRows.parseTime(min);
		}
		return null;
	}

}
