package com.pearson.dtotest;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pearson.dto.Store;
import com.pearson.responsemessage.StoreResponse;

@WebMvcTest(value = StoreResponse.class)
class StoreTest {

	String json = " {\"storeId\":\"1525eec4-7bed-4597-bf5a-e06fcede5f4f\",\"postCode\":\"AB11 5PS\",\"city\":\"Aberdeen\",\"address\":\"LSU 1A Union Square Guild Street\",\"openingDate\":\"21/02/1965\"}";
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void test() throws JsonProcessingException, JSONException {
		Store stores = new Store();
		stores.setStoreId("1525eec4-7bed-4597-bf5a-e06fcede5f4f");
		stores.setPostCode("AB11 5PS");
		stores.setCity("Aberdeen");
		stores.setAddress("LSU 1A Union Square Guild Street");
		stores.setOpeningDate("21/02/1965");

		Store store = mapper.readValue(json, Store.class);

		JSONAssert.assertEquals(json, mapper.writeValueAsString(store), false);
	}
}
