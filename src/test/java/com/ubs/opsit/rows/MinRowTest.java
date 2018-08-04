package com.ubs.opsit.rows;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class MinRowTest {

	@InjectMocks
	MinRow minRow;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testParseTimeFor369RedSuccess() {
		Assert.assertEquals(minRow.parseTime(51), "YYRYYRYYRYO\r\nYOOO");
		Assert.assertEquals(minRow.parseTime(15), "YYROOOOOOOO\r\nOOOO");
		Assert.assertEquals(minRow.parseTime(30), "YYRYYROOOOO\r\nOOOO");
		
	}
	
	@Test
	public void testParseTime1minRowSuccess() {
		Assert.assertEquals(minRow.parseTime(11), "YYOOOOOOOOO\r\nYOOO");
		Assert.assertEquals(minRow.parseTime(12), "YYOOOOOOOOO\r\nYYOO");
		Assert.assertEquals(minRow.parseTime(13), "YYOOOOOOOOO\r\nYYYO");
		Assert.assertEquals(minRow.parseTime(14), "YYOOOOOOOOO\r\nYYYY");
		
		
	}
	
	@Test(expected= RuntimeException.class)
	public void testParseTimeFail() {
		minRow.parseTime(-1);
	}
}
