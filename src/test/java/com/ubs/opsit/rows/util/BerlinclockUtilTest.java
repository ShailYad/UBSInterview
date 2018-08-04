package com.ubs.opsit.rows.util;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.ubs.opsit.util.BerlinClockUtil;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class BerlinclockUtilTest {
	
	@InjectMocks
	BerlinClockUtil berlinClockUtil;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testDisplayLampSuccess() {
		Assert.assertEquals(berlinClockUtil.displayLamp(10, 11, berlinClockUtil.COLOR_Y,null), "YYYYYYYYYYO");
		Assert.assertEquals(berlinClockUtil.displayLamp(4, 5, berlinClockUtil.COLOR_Y,null), "YYYYO");
		
	}
	
	@Test
	public void testDisplayLampChangeColorSuccess() {
		Assert.assertEquals(berlinClockUtil.displayLamp(10, 11, berlinClockUtil.COLOR_Y,Arrays.asList(1,2,3)), "RRRYYYYYYYO");
		Assert.assertEquals(berlinClockUtil.displayLamp(4, 5, berlinClockUtil.COLOR_Y,Arrays.asList(3)), "YYRYO");
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testDisplayLampOncountGreaterThanRowFail() {
		Assert.assertEquals(berlinClockUtil.displayLamp(12, 11, berlinClockUtil.COLOR_Y,null), "YYYYYYYYYYO");
		
	}


}
