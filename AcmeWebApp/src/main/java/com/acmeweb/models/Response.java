package com.acmeweb.models;

public class Response {
	
	String status;
		
	public Response() {
	}

	public Response(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}
