package com.telstra.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.telstra.constants.TelstraConstants;
import com.telstra.exceptions.InvalidInputValidationException;
import com.telstra.model.NumberArrays;
import com.telstra.model.SingleArray;
import com.telstra.rest.BaseTest;

public class RestServiceImplTest extends BaseTest {

	@InjectMocks
	private RestServiceImpl restServiceImpl;

	@Test
	public void testReverseWords() {
		String reverseWordActual = restServiceImpl.getReverseWords(TelstraConstants.SENTENCE_REQUEST);
		assertEquals(TelstraConstants.SENTENCE_RESPONSE, reverseWordActual);
	}

	@Test
	public void testEquilateral() {
		String str = restServiceImpl.getTraingleType("1", "1", "1").getTriangleType();
		assertEquals(RestServiceImpl.TRIANGLE.EQUILATERAL.name(), str);
	}

	@Test
	public void testIsosceles() {
		String str = restServiceImpl.getTraingleType("1", "2", "1").getTriangleType();
		assertEquals(RestServiceImpl.TRIANGLE.ISOSCELES.name(), str);
	}

	@Test
	public void testScalene() {
		String str = restServiceImpl.getTraingleType("1", "2", "3").getTriangleType();
		assertEquals(RestServiceImpl.TRIANGLE.SCALENE.name(), str);
	}

	@Test
	public void testFibonacci() {
		Integer fibonacciActual = restServiceImpl.getFibonaciNumber(TelstraConstants.NUMBER_REQ);
		assertEquals(new Integer(TelstraConstants.NUMBER_RES), fibonacciActual);
	}

	@Test
	public void testFibonacciException() throws InvalidInputValidationException {

		exception.expect(InvalidInputValidationException.class);
		exception.expectMessage(TelstraConstants.INVALID_INPUT);
		verify(restServiceImpl.getFibonaciNumber(TelstraConstants.NUMBER_REQ + TelstraConstants.SENTENCE_REQUEST));

	}

	@Test(expected = NullPointerException.class)
	public void testReverseWordsWhenNullException() {
		verify(restServiceImpl.getReverseWords(null));

	}
	
	 
	@Test
	public void testTraingleTypeWhenException() throws InvalidInputValidationException {

		exception.expect(InvalidInputValidationException.class);
		exception.expectMessage(TelstraConstants.INVALID_INPUT);
		verify(restServiceImpl.getTraingleType(TelstraConstants.NUMBER_REQ1, TelstraConstants.NUMBER_REQ2, TelstraConstants.NUMBER_REQ3 + TelstraConstants.SENTENCE_REQUEST));

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testMakeOneArray () {
        NumberArrays numberArrs = createMakeOneArray();
        SingleArray expected = createSingleArray();
        
		SingleArray singleArrayActual = restServiceImpl.makeOneArray(numberArrs);
		assertEquals(expected.getArray(), singleArrayActual.getArray());
	}
	

	
}
