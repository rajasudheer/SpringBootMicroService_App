package com.telstra.common.util;

import static org.junit.Assert.assertTrue;

import com.telstra.rest.BaseTest;
import com.telstra.utils.CommonUtil;

public class CommonUtilTest extends BaseTest{

	public void testTriangleType(){
		boolean triangleType = CommonUtil.isTriangleType("1", "2", "3");
		assertTrue(triangleType);
	}
	
	public void testDigitNumber(){
		boolean fibonacci = CommonUtil.isNumber("10");
		assertTrue(fibonacci);
	}
}
