package com.telstra.rest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;

import com.telstra.model.NumberArrays;
import com.telstra.model.SingleArray;
import com.telstra.model.TriangleType;

public class BaseTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
	}

	public TriangleType createTriangleType() {
		TriangleType type = new TriangleType();
		type.getTriangleType();
		return type;
	}

	public NumberArrays createMakeOneArray() {
		NumberArrays numberArrays = new NumberArrays();

		Integer[] array1 = { 1, 2, 3 };
		Integer[] array2 = { 1, 2, 5 };

		Integer[] array3 = { 6, 7, 8 };

		numberArrays.setArray1(array1);
		numberArrays.setArray2(array2);
		numberArrays.setArray3(array3);

		return numberArrays;

	}
	
	public SingleArray createSingleArray() {
		SingleArray singleArray = new SingleArray();

		Integer[] array1 = { 1, 2, 3,5,6,7,8 };
		
		singleArray.setArray(array1);
		
		return singleArray;

	}
}
