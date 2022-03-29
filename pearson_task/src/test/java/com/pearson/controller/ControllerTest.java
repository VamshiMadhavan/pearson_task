package com.pearson.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pearson.dto.Store;
import com.pearson.responsemessage.StoreResponse;
import com.pearson.responsemessage.StoresResponse;

@WebMvcTest(value = StoreController.class)
class ControllerTest {

	@MockBean
	private StoreController controller;

	@Autowired
	private MockMvc mockMvc;

	Store store = new Store("1525eec4-7bed-4597-bf5a-e06fcede5f4f", "AB11 5PS", "Aberdeen",
			"LSU 1A Union Square Guild Street", "21/02/1965");
	/*
	 * Store stores1 = new Store("15773203-9ce4-4ee1-9373-543b940fa293", "AB25 1HZ",
	 * "Aberdeen", "1 Bon Accord CentreGeorge Street", "20/01/1982"); Store stores2
	 * = new Store("f202ea77-6237-4caf-8d97-03c10d41a53c", "AB42 1 ZP", "Peterhead",
	 * "Unit B1 Drummers Corner", "12/03/1994"); Store stores3 = new
	 * Store("859aac4f-e34d-4392-aef7-9c0c14e49782", "G81 2TL", "Clydebank",
	 * "106 Sylvania Wayr", "13/06/1958"); Store stores4 = new
	 * Store("99d806bf-e630-490d-a769-7a76c0db3d92", "G82 1LJ", "Dumbarton",
	 * "Unit 12 The Artizan Centre", "28/01/1970"); Store stores5 = new
	 * Store("1434b5a1-f070-4aad-b93b-8bcf8ebe56fe", "GL1 1QN", "Gloucester",
	 * "5-7 Brunswick Road", "30/09/2002"); Store stores6 = new
	 * Store("5cbad6e9-0574-40ce-938c-37ad3b1a9b3d", "GL5 1RR", "Stroud",
	 * "Unit C Merrywalks Shopping Centre", "31/10/1994");
	 */

	List<Store> list = Arrays.asList(store);
	StoreResponse storeResponse = new StoreResponse("success", store);
	//StoresResponse storesResponse = new StoresResponse("success", list);

	@Test
	public void testGetAll() throws Exception {

		Mockito.when(controller.getAll()).thenReturn(new ResponseEntity<StoresResponse>(HttpStatus.OK));

		String myString = "/getAll";

		MockHttpServletRequestBuilder resultBuilder = MockMvcRequestBuilders.get(myString)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(resultBuilder).andReturn();

		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

	}

	@Test
	public void testOrderedByCities() throws Exception {
		Mockito.when(controller.orderedByCity()).thenReturn(new ResponseEntity<StoresResponse>(HttpStatus.OK));

		String myString = "/orederedByCities";

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(myString).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

	@Test
	public void testOrderedByDate() throws Exception {
		Mockito.when(controller.orderedByOpeningDate()).thenReturn(new ResponseEntity<StoresResponse>(HttpStatus.OK));

		String myString = "/orederedByOpeningDate";

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(myString).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

	@Test
	public void testGetByStoreId() throws Exception {

		Mockito.when(controller.getByStoreId(Mockito.anyString()))
				.thenReturn(new ResponseEntity<StoreResponse>(storeResponse, HttpStatus.OK));

		String myString = "/getByStoreId?storeId=1525eec4-7bed-4597-bf5a-e06fcede5f4f";

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(myString).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

//	@InjectMocks
//	private StoreController storeController;
//
//	@MockBean
//	private StoreSevice storeSevice;
//
//	@Autowired
//	private MockMvc mockMvc;
//	Stores stores = new Stores("1525eec4-7bed-4597-bf5a-e06fcede5f4f", "AB11 5PS", "Aberdeen",
//			"LSU 1A Union Square Guild Street", "21/02/1965");
//	Stores stores1 = new Stores("15773203-9ce4-4ee1-9373-543b940fa293", "AB25 1HZ", "Aberdeen",
//			"1 Bon Accord CentreGeorge Street", "20/01/1982");
//	Stores stores2 = new Stores("f202ea77-6237-4caf-8d97-03c10d41a53c", "AB42 1 ZP", "Peterhead",
//			"Unit B1 Drummers Corner", "12/03/1994");
//	Stores stores3 = new Stores("859aac4f-e34d-4392-aef7-9c0c14e49782", "G81 2TL", "Clydebank", "106 Sylvania Wayr",
//			"13/06/1958");
//	Stores stores4 = new Stores("99d806bf-e630-490d-a769-7a76c0db3d92", "G82 1LJ", "Dumbarton",
//			"Unit 12 The Artizan Centre", "28/01/1970");
//	Stores stores5 = new Stores("1434b5a1-f070-4aad-b93b-8bcf8ebe56fe", "GL1 1QN", "Gloucester", "5-7 Brunswick Road",
//			"30/09/2002");
//	Stores stores6 = new Stores("5cbad6e9-0574-40ce-938c-37ad3b1a9b3d", "GL5 1RR", "Stroud",
//			"Unit C Merrywalks Shopping Centre", "31/10/1994");
//
//	@Test
//	public void getAll() throws Exception {
//		String myString = "localhost:7070/stores/getAll";
//		List<Stores> list = Arrays.asList(stores, stores1, stores2, stores3, stores4, stores5, stores6);
//
//		Mockito.when(storeSevice.getAll()).thenReturn(list);
//		MockHttpServletRequestBuilder resultBuilder = MockMvcRequestBuilders.get(myString)
//				.accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(resultBuilder).andReturn();
//
//		List<Stores> expected = list;
//
//		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
//	}

}
