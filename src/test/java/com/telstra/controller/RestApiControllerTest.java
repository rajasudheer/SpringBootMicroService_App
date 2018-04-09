package com.telstra.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.telstra.constants.TelstraConstants;
import com.telstra.exceptions.InvalidInputValidationException;
import com.telstra.model.NumberArrays;
import com.telstra.model.SingleArray;
import com.telstra.model.TriangleType;
import com.telstra.rest.BaseTest;
import com.telstra.service.RestService;

public class RestApiControllerTest extends BaseTest {

	@Mock
	private RestService restService;

	@InjectMocks
	private RestApiController restApiController;

	@Mock
	private HttpServletResponse httpServletResponse;

	@Test
	public void testFibonaciNumber() {
		when(restService.getFibonaciNumber(TelstraConstants.NUMBER_REQ)).thenReturn(TelstraConstants.NUMBER_RES);
		ResponseEntity<Integer> actualResponse = restApiController.getFibonaciNumber(TelstraConstants.NUMBER_REQ);
		assertNotNull(actualResponse);
		assertEquals(TelstraConstants.NUMBER_RES, actualResponse.getBody());
	}
	
	@Test
	public void testFibonaciNumberWhenException() {
		exception.expect(InvalidInputValidationException.class);
		exception.expectMessage(TelstraConstants.INVALID_INPUT);
		verify(restApiController.getFibonaciNumber(TelstraConstants.NUMBER_REQ+TelstraConstants.SENTENCE_REQUEST));
		
	}

	@Test
	public void testReverseWords() {
		when(restService.getReverseWords(TelstraConstants.SENTENCE_REQUEST))
				.thenReturn(TelstraConstants.SENTENCE_RESPONSE);
		ResponseEntity<String> actualResponse = restApiController.getReverseWords(TelstraConstants.SENTENCE_REQUEST);
		assertNotNull(actualResponse);
		assertEquals(TelstraConstants.SENTENCE_RESPONSE, actualResponse.getBody());
	}

	@Test
	public void testTriangleType() {
		TriangleType expectedResponse = createTriangleType();
		when(restService.getTraingleType(TelstraConstants.NUMBER_REQ1, TelstraConstants.NUMBER_REQ2,
				TelstraConstants.NUMBER_REQ3)).thenReturn(expectedResponse);
		ResponseEntity<String> actualResponse = restApiController.getTraingleType(TelstraConstants.NUMBER_REQ1,
				TelstraConstants.NUMBER_REQ2, TelstraConstants.NUMBER_REQ3);
		assertNotNull(actualResponse);
		assertEquals(expectedResponse.getTriangleType(), actualResponse.getBody());
	}

	@Test
	public void testTriangelTypeWhenException() throws InvalidInputValidationException {
		exception.expect(InvalidInputValidationException.class);
		exception.expectMessage(TelstraConstants.INVALID_INPUT);
		verify(restApiController.getTraingleType("a1", "b1", "c1"));
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testMakeOneArray() {
		NumberArrays numberArrs = createMakeOneArray();
		SingleArray expected = createSingleArray();
		when(restService.makeOneArray(numberArrs)).thenReturn(expected);
		
		ResponseEntity<SingleArray> actualResponse = restApiController.makeOneArray(numberArrs);
		assertNotNull(actualResponse);
		assertEquals(expected, actualResponse.getBody());
	}

}
