package com.telstra.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SingleArray {
	
	@JsonProperty("Array")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object[] array;

	/**
	 * @return the array
	 */
	public Object[] getArray() {
		return array;
	}

	/**
	 * @param array the array to set
	 */
	public void setArray(Object[] array) {
		this.array = array;
	}

}
