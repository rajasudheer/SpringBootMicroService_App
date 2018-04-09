package com.telstra.controller;



import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.constants.TelstraConstants;
import com.telstra.exceptions.InvalidInputValidationException;
import com.telstra.model.NumberArrays;
import com.telstra.model.SingleArray;
import com.telstra.model.TriangleType;
import com.telstra.service.RestService;
import com.telstra.utils.CommonUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	private RestService restService;

	@Autowired
	private HttpServletResponse httpServletResponse;

	@RequestMapping(value = "/Fibonacci", method = RequestMethod.GET)
	@ApiOperation(value = "Fetches Fibonacci Series For the Given Numbers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved series"),
			@ApiResponse(code = 400, message = "Status 400"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Status 500"), @ApiResponse(code = 503, message = "Status 503") })

	public ResponseEntity<Integer> getFibonaciNumber(@RequestParam(name = "n", required = true) String number)
			throws InvalidInputValidationException {
		httpServletResponse.setHeader("pragma", "no-cache");
		httpServletResponse.setHeader("cache-control", "no-cache");
		if (!CommonUtil.isNumber(number)) {
			throw new InvalidInputValidationException(TelstraConstants.INVALID_INPUT);
		}
		Integer nthFibonacinumber = restService.getFibonaciNumber(number);
		return new ResponseEntity<Integer>(nthFibonacinumber, HttpStatus.OK);
	}

	

	@RequestMapping(value = "/ReverseWords", method = RequestMethod.GET)
	@ApiOperation(value = "Reverses the letters of each word in a sentence.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Reverse Sentence"),
			@ApiResponse(code = 400, message = "Status 400"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Status 500"), @ApiResponse(code = 503, message = "Status 503") })

	public ResponseEntity<String> getReverseWords(@RequestParam String sentence) {
		httpServletResponse.setHeader("pragma", "no-cache");
		httpServletResponse.setHeader("cache-control", "no-cache");
		String reverseWords = restService.getReverseWords(sentence);
		return new ResponseEntity<String>(reverseWords, HttpStatus.OK);
	}

	@RequestMapping(value = "/TriangleType", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the type of triangle given the lengths of its sides")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Known the Triangle Type"),
			@ApiResponse(code = 400, message = "Status 400"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Status 500"), @ApiResponse(code = 503, message = "Status 503") })

	public ResponseEntity<String> getTraingleType(@RequestParam(name = "a", required = true) String a,
			@RequestParam(name = "b", required = true) String b,
			@RequestParam(name = "c", required = true) String c) {
		httpServletResponse.setHeader("pragma", "no-cache");
		httpServletResponse.setHeader("cache-control", "no-cache");
		if(!CommonUtil.isTriangleType(a, b, c)) {
			throw new InvalidInputValidationException(TelstraConstants.INVALID_INPUT);
		}
		TriangleType triangleType = restService.getTraingleType(a, b, c);
		return new ResponseEntity<String>(triangleType.getTriangleType(), HttpStatus.OK);
	}

	@RequestMapping(value = "/makeonearray", method = RequestMethod.POST)
	@ApiOperation(value = "Combine, remove duplicate and sort all input arrays in request JSON object.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Combined the arrays"),
			@ApiResponse(code = 400, message = "Status 400"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Status 500"), @ApiResponse(code = 503, message = "Status 503") })

	public ResponseEntity<SingleArray> makeOneArray(@Valid @RequestBody NumberArrays numberArrs) {
		
		httpServletResponse.setHeader("pragma", "no-cache");
		httpServletResponse.setHeader("cache-control", "no-cache");
		
		SingleArray singleArray = restService.makeOneArray(numberArrs);
		return new ResponseEntity<SingleArray>(singleArray, HttpStatus.OK);
	}
	
	

		
}
