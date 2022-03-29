package com.pearson.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pearson.dto.Store;
import com.pearson.service.StoreService;

@SpringBootTest
public class ServiceTest {

	@Mock
	private StoreService service;
	Store store = new Store("1525eec4-7bed-4597-bf5a-e06fcede5f4f", "AB11 5PS", "Aberdeen",
			"LSU 1A Union Square Guild Street", "21/02/1965");
	Store stores1 = new Store("15773203-9ce4-4ee1-9373-543b940fa293", "AB25 1HZ", "Aberdeen",
			"1 Bon Accord CentreGeorge Street", "20/01/1982");
	Store stores2 = new Store("f202ea77-6237-4caf-8d97-03c10d41a53c", "AB42 1 ZP", "Peterhead",
			"Unit B1 Drummers Corner", "12/03/1994");
	Store stores3 = new Store("859aac4f-e34d-4392-aef7-9c0c14e49782", "G81 2TL", "Clydebank", "106 Sylvania Wayr",
			"13/06/1958");
	Store stores4 = new Store("99d806bf-e630-490d-a769-7a76c0db3d92", "G82 1LJ", "Dumbarton",
			"Unit 12 The Artizan Centre", "28/01/1970");
	Store stores5 = new Store("1434b5a1-f070-4aad-b93b-8bcf8ebe56fe", "GL1 1QN", "Gloucester", "5-7 Brunswick Road",
			"30/09/2002");
	Store stores6 = new Store("5cbad6e9-0574-40ce-938c-37ad3b1a9b3d", "GL5 1RR", "Stroud",
			"Unit C Merrywalks Shopping Centre", "31/10/1994");

	List<Store> list = Arrays.asList(store, stores1, stores2, stores3, stores4, stores5, stores6);

	@Test
	public void testGetStoresById() {
		Mockito.when(service.getStoreById(Mockito.anyString())).thenReturn(store);
		String id = "1525eec4-7bed-4597-bf5a-e06fcede5f4f";
		Store storeById = service.getStoreById(id);
		assertEquals(store, storeById);
	}

	@Test
	public void testGetAll() {
		Mockito.when(service.getAll()).thenReturn(list);
		List<Store> all = service.getAll();
		assertEquals(list, all);
	}

	@Test
	public void testGetStoresOrderesByCity() {

		Mockito.when(service.getStoresOrderesByCity()).thenReturn(list.stream()
				.sorted((store1, store2) -> store1.getCity().compareTo(store2.getCity())).collect(Collectors.toList()));
		List<Store> storesOrderesByCity = service.getStoresOrderesByCity();
		assertEquals(list.stream().sorted((store1, store2) -> store1.getCity().compareTo(store2.getCity()))
				.collect(Collectors.toList()), storesOrderesByCity);
	}

	@Test
	public void testGetStoresOrderesByDate() {

		Mockito.when(service.getStoresOrderesByCity())
				.thenReturn(list.stream()
						.sorted((store1, store2) -> store1.getOpeningDate().compareTo(store2.getOpeningDate()))
						.collect(Collectors.toList()));
		List<Store> storesOrderesByCity = service.getStoresOrderesByCity();
		assertEquals(
				list.stream().sorted((store1, store2) -> store1.getOpeningDate().compareTo(store2.getOpeningDate()))
						.collect(Collectors.toList()),
				storesOrderesByCity);
	}

}
