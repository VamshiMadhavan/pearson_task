package com.pearson.service;

import java.util.List;

import com.pearson.dto.Store;

public interface StoreService {

	public Store getStoreById(String storeId);

	public List<Store> getStoresOrderesByCity();

	public List<Store> getStoresOrderesByDate();

	public List<Store> getAll();

}