package com.srm.spring.dto;

/**
 * @author marimuthu
 *
 */
public class APISuccessPayload {
	
	private String message;
	
	private Object body;
	
	private Object statusCode;
	
	private Boolean sucess=true;
	
	private String cause;


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public Object getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Object statusCode) {
		this.statusCode = statusCode;
	}

	public Boolean getSucess() {
		return sucess;
	}

	public void setSucess(Boolean sucess) {
		this.sucess = sucess;
	}
	
	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
	
	
}
