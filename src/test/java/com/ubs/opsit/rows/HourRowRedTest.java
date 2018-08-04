package com.ubs.opsit.rows;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class HourRowRedTest {
	
	@InjectMocks
	HourRowRed hourRowRed;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testParseTimeRowSuccess() {
		Assert.assertEquals(hourRowRed.parseTime(13), "RROO\r\nRRRO");
		Assert.assertEquals(hourRowRed.parseTime(10), "RROO\r\nOOOO");
		Assert.assertEquals(hourRowRed.parseTime(24), "RRRR\r\nRRRR");
		
	}
	
	@Test(expected= RuntimeException.class)
	public void parseTimeFail() {
		hourRowRed.parseTime(-1);
	}

}
