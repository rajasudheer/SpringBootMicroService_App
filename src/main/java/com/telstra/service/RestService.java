package com.telstra.service;

import com.telstra.model.NumberArrays;
import com.telstra.model.SingleArray;
import com.telstra.model.TriangleType;

public interface RestService {
	
	 SingleArray makeOneArray(NumberArrays numberArrs);
	 
	 TriangleType getTraingleType(String a,String b,String c);
	 
	 String getReverseWords(String sentence);
	 
	 Integer getFibonaciNumber(String number);

}
