package com.nacho.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Success implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private boolean success;
	@JsonInclude(Include.NON_NULL)
	private Map<String, String> data;
	
	public Success () {
		
	}
	
	public Success(boolean success) {
		this.success = success;
	}
	
	public Success(boolean success, String token) {
		this.success = success;
		this.data = new HashMap<String, String>();
		this.data.put("token", token);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}
	
	
}
