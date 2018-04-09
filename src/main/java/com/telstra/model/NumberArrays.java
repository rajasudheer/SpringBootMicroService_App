package com.telstra.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NumberArrays {

	@JsonProperty("Array1")
	@NotNull
	@Size(min = 1, message = "Array1 should have minimum one digit")
	
	//@Pattern(regexp = "\"^\\\\d,+$\"",message="array1 allows only numbers")
	//@Pattern(regexp="^[\\\\d,]+$",message="array1 allows only numbers")
	private Integer[] array1;

	@JsonProperty("Array2")
	@NotNull
	@Size(min = 1, message = "Array2 should have minimum one digit")
	//@Pattern(regexp = "\"^\\\\d,+$\"",message="array2 allows only numbers")
	//@Pattern(regexp="^[\\\\d,]+$",message="array1 allows only numbers")
	private Integer[] array2;

	@JsonProperty("Array3")
	@Size(min = 1, message = "Array3 should have minimum one digit")
	//@Pattern(regexp="^[\\\\d,]+$",message="array1 allows only numbers")
	//@Pattern(regexp = "\"^\\\\d,+$\"",message="array3 allows only numbers")

	private Integer[] array3;

	public Integer[] getArray1() {
		return array1;
	}

	public void setArray1(Integer[] array1) {
		this.array1 = array1;
	}

	public Integer[] getArray2() {
		return array2;
	}

	public void setArray2(Integer[] array2) {
		this.array2 = array2;
	}

	public Integer[] getArray3() {
		return array3;
	}

	public void setArray3(Integer[] array3) {
		this.array3 = array3;
	}

}
