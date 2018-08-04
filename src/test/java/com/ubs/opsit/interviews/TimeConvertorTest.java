package com.ubs.opsit.interviews;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.ubs.opsit.rows.FirstBlinkYellowRow;
import com.ubs.opsit.rows.HourRowRed;
import com.ubs.opsit.rows.MinRow;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TimeConvertorTest {
	@InjectMocks
	TimeConvertorImpl timeConverter;
	
	@Mock
	FirstBlinkYellowRow firstBlinkYellowRow;
	
	@Mock
	HourRowRed hourRowRed;

	@Mock
	MinRow minRow;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void testConvertTimeSucess() {
		when(firstBlinkYellowRow.parseTime(anyInt())).thenReturn("O");
		when(hourRowRed.parseTime(anyInt())).thenReturn("RROO\r\nRRRO");
		when(minRow.parseTime(anyInt())).thenReturn("YYROOOOOOOO\r\nYYOO\r\n");
		System.out.println(timeConverter.convertTime("13:17:01"));
		Assert.assertEquals(timeConverter.convertTime("13:17:01"), "O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO\r\n");
	}
	
	
	@Test(expected = NumberFormatException.class)
	public void testConvertTimeFailiure() {
		timeConverter.convertTime("ss:17:01");
	}
	
	@Test
	public void testConvertTimeWithHHMM() {
		Assert.assertNull(timeConverter.convertTime("22:17"));
	}

}
