package com.pearson.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.dto.Store;
import com.pearson.responsemessage.StoreResponse;
import com.pearson.responsemessage.StoresResponse;
import com.pearson.service.StoreServiceImpl;

@RestController
@RequestMapping("/")
public class StoreController {

	@Autowired
	private StoreServiceImpl storeServiceImpl;

	@GetMapping("getAll")
	public ResponseEntity<StoresResponse> getAll() {
		List<Store> all = storeServiceImpl.getAll();
		StoresResponse response = new StoresResponse("stores", all);
		return new ResponseEntity<StoresResponse>(response, HttpStatus.OK);
	}

	@GetMapping("getByStoreId")
	public ResponseEntity<StoreResponse> getByStoreId(@RequestParam String storeId) {
		Store storeById = storeServiceImpl.getStoreById(storeId);
		StoreResponse storeResponse = new StoreResponse();
		if (storeById == null) {
			storeResponse.setMessage("Invalid Store Id");
			storeResponse.setObject(null);
			return new ResponseEntity<StoreResponse>(storeResponse, HttpStatus.BAD_REQUEST);
		}
		storeResponse.setMessage("The Store Data Is");
		storeResponse.setObject(storeById);
		return new ResponseEntity<StoreResponse>(storeResponse, HttpStatus.OK);
	}

	@GetMapping("orederedByCities")
	public ResponseEntity<StoresResponse> orderedByCity() {
		return new ResponseEntity<StoresResponse>(
				new StoresResponse("Sorted By Cities", storeServiceImpl.getStoresOrderesByCity()), HttpStatus.OK);

	}

	@GetMapping("orederedByOpeningDate")
	public ResponseEntity<StoresResponse> orderedByOpeningDate() {
		return new ResponseEntity<StoresResponse>(
				new StoresResponse("Sorted By OpeningDate", storeServiceImpl.getStoresOrderesByDate()), HttpStatus.OK);

	}

}
