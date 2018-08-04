package com.ubs.opsit.util;

import java.util.List;

public class BerlinClockUtil {
	public static final String NEXTLINE = "\r\n";
	public static final String COLOR_Y = "Y";
	public static final String COLOR_R = "R";
	public static final String COLOR_O = "O";

	public static String displayLamp(int div, int rowLength, String color, List<Integer> redcolor) {
		if(div > rowLength) {
			throw new RuntimeException("Illegal Argument");
		}
		StringBuffer sb = new StringBuffer("");
		for (int i = 1; i <= rowLength; i++) {
			if (div >= i) {
		 		if (null != redcolor && redcolor.contains(i)) {
					sb.append(COLOR_R);
				} else {
					sb.append(color);
				}
				continue;
			}
			sb.append(COLOR_O);
		}
		return sb.toString();
	}
	
}
