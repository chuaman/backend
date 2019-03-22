package com.youtube.demo.util;

public class RestResponse {
	
	private Integer reponseCode;
	private String message;
	
	
	
	
	public RestResponse(Integer reponseCode) {
		super();
		this.reponseCode = reponseCode;
	}
	
	

	public RestResponse(Integer reponseCode, String message) {
		super();
		this.reponseCode = reponseCode;
		this.message = message;
	}









	public Integer getReponseCode() {
		return reponseCode;
	}
	public void setReponseCode(Integer reponseCode) {
		this.reponseCode = reponseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
