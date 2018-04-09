package com.telstra.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.telstra.constants.TelstraConstants;
import com.telstra.exceptions.InvalidInputValidationException;
import com.telstra.model.NumberArrays;
import com.telstra.model.SingleArray;
import com.telstra.model.TriangleType;
import com.telstra.service.RestService;
import com.telstra.utils.CommonUtil;

@Component
public class RestServiceImpl implements RestService {

	public enum TRIANGLE {
		EQUILATERAL, ISOSCELES, SCALENE
	}

	@Override
	public Integer getFibonaciNumber(String number) {
		int a = 0;
		int b = 1;
		if (number != null && CommonUtil.isNumber(number)) {
			Long ln = Long.parseLong(number);
			for (int i = 1; i <= ln; i++) {
				int temp = a;
				a = a + b;
				b = temp;
			}

		} else {
			throw new InvalidInputValidationException(TelstraConstants.INVALID_INPUT);
		}
		return a;
	}

	@Override
	public String getReverseWords(String sentence) {
		StringBuilder revBuilder = null;
		String resultReverse = "";

		if (sentence != null && !StringUtils.isEmpty(sentence)) {
			Pattern pattern = Pattern.compile("\\s");
			String[] temp = pattern.split(sentence);
			for (int i = 0; i < temp.length; i++) {
				if (i == temp.length - 1)
					resultReverse = temp[i] + resultReverse;
				else
					resultReverse = " " + temp[i] + resultReverse;
			}
			revBuilder = new StringBuilder(resultReverse);
		} else {
			throw new NullPointerException();
		}

		return revBuilder.reverse().toString();

	}

	@Override
	public TriangleType getTraingleType(String x, String y, String z) {
		TriangleType triangleType = new TriangleType();

		/*
		 * if (CommonUtil.isTriangleType(x, y, z)) { throw new
		 * InvalidInputValidationException("Only numbers are allowed"); }
		 */

		if (CommonUtil.isTriangleType(x, y, z)) {
			Integer a = Integer.parseInt(x);
			Integer b = Integer.parseInt(y);
			Integer c = Integer.parseInt(z);

			if (a == b && b == c) {
				triangleType.setTriangleType(TRIANGLE.EQUILATERAL.name());
				return triangleType;
			}

			else if ((a == b) || (c == a) || (c == b)) {
				triangleType.setTriangleType(TRIANGLE.ISOSCELES.name());
				return triangleType;
			}

			else {
				triangleType.setTriangleType(TRIANGLE.SCALENE.name());
				return triangleType;
			}

		} else {
			throw new InvalidInputValidationException(TelstraConstants.INVALID_INPUT);
		}
	}

	@Override
	public SingleArray makeOneArray(NumberArrays numberArrs) {
		Integer[] array1 = numberArrs.getArray1();
		Integer[] array2 = numberArrs.getArray2();
		Integer[] array3 = numberArrs.getArray3();

		List<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(array1));
		listWithDuplicates.addAll(Arrays.asList(array2));
		listWithDuplicates.addAll(Arrays.asList(array3));

		// Removing duplicates from the list using Java 8 Streams
		List<Integer> listWithoutDuplicates = listWithDuplicates.stream().distinct().sorted()
				.collect(Collectors.toList());
		SingleArray singleArray = new SingleArray();
		singleArray.setArray(listWithoutDuplicates.toArray());
		return singleArray;
	}

}
