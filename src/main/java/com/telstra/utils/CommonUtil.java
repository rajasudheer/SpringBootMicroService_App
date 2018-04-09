package com.telstra.utils;

public class CommonUtil {
	
	
	public static boolean isTriangleType(String a,String b,String c) {
		String triangleType = (a+b+c).trim();
		return triangleType.matches("^\\d+$");
	}	
	
	public static boolean isNumber(String string) {
		return string.matches("^\\d+$");
	}
}
