package com.telstra.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.telstra.exceptions.ErrorResponse;
import com.telstra.rest.BaseTest;

public class ServiceErrorControllerTest extends BaseTest{

	@InjectMocks
	private ServiceErrorController serviceErrorController;

	@Test
	public void verifyHandleException() {
		ResponseEntity<ErrorResponse> response = serviceErrorController.exceptionHandler((mock(Exception.class)));
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCodeValue());
	}
}
