package com.pearson.responsemessage;

import java.util.List;

import com.pearson.dto.Store;

public class StoresResponse {
	private String message;
	private List<Store> stores;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Store> getStores() {
		return stores;
	}

	public StoresResponse(String message, List<Store> stores) {
		super();
		this.message = message;
		this.stores = stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public StoresResponse() {
		super();
	}

}
