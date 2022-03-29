package com.pearson.dto;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Store implements Serializable {

	private String storeId;

	private String postCode;

	private String city;

	private String address;

	private String openingDate;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String date) {
		this.openingDate = date;
	}

	public Store(String storeId, String postCode, String city, String address, String openingDate) {
		super();
		this.storeId = storeId;
		this.postCode = postCode;
		this.city = city;
		this.address = address;
		this.openingDate = openingDate;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", postCode=" + postCode + ", city=" + city + ", address=" + address
				+ ", openingDate=" + openingDate + "]";
	}

	public Store() {
		super();
	}

}
