package com.ubs.opsit.rows;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FirstBlinkYellowRowTest {
	@InjectMocks
	FirstBlinkYellowRow firstBlink;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testParseTime2SecBlinkSuccess() {
		Assert.assertEquals(firstBlink.parseTime(0), "Y");
		Assert.assertEquals(firstBlink.parseTime(1), "O");
		Assert.assertEquals(firstBlink.parseTime(2), "Y");
		
	}
	
	@Test(expected= RuntimeException.class)
	public void testParseTimeFail() {
		firstBlink.parseTime(-1);
	}
}
