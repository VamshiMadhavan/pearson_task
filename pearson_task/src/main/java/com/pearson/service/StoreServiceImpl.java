package com.pearson.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pearson.dto.Store;

@Service
public class StoreServiceImpl implements StoreService {

	@Override
	public Store getStoreById(String storeId) {
		return getAll().stream().filter(Stores -> Stores.getStoreId().equals(storeId)).findAny().orElse(null);

	}

	@Override
	public List<Store> getStoresOrderesByCity() {
		return getAll().stream().sorted((store1, store2) -> store1.getCity().compareTo(store2.getCity()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Store> getStoresOrderesByDate() {
		return getAll().stream().sorted((store1, store2) -> store1.getOpeningDate().compareTo(store2.getOpeningDate()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Store> getAll() {
		String line = "";
		BufferedReader bufferedReader = null;
		List<Store> storesList = new ArrayList<>();
		try {

			// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			bufferedReader = new BufferedReader(new FileReader("src/main/resources/Stores.csv"));
			while ((line = bufferedReader.readLine()) != null) {
				Store stores = new Store();
				String[] split = line.split(",");
				stores.setStoreId(split[0]);
				stores.setPostCode(split[1]);
				stores.setCity(split[2]);
				stores.setAddress(split[3]);
				stores.setOpeningDate((split[4]));
				System.out.println(stores);
				storesList.add(stores);
			}
			return storesList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
