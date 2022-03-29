package com.pearson.responsemessage;

public class StoreResponse {
	private String message;
	private Object object;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + ", object=" + object + "]";
	}

	public StoreResponse(String message, Object object) {
		super();
		this.message = message;
		this.object = object;
	}

	public StoreResponse() {
		super();
	}

}
