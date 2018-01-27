package com.intercom.customer_test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.intercom.customer_test.model.Customer;
import com.intercom.customer_test.utils.FileUtils;
import com.intercom.customer_test.utils.GeoUtils;

import junit.framework.TestCase;


public class AppTest extends TestCase {
	
	public void test_geoUtils_getDistance() {
		
		double lat = 53.2451022;
		double lon = -6.238335;
		
		double expectedDistance = 10.566936288867613;
		
		double distance = GeoUtils.getDistance(lat, lon);
		
		assertEquals(distance, expectedDistance);
	}
	
	public void test_geoUtils_getCentralAngle() {
		
		double lat = Math.toRadians(53.2451022);
		double lon = Math.toRadians(-6.238335);
		double expectedAngle = 0.0016585993233193552;
		
		double angle = GeoUtils.getCentralAngle(lat, lon);
		
		assertEquals(expectedAngle, angle);
	}
	
	public void test_fileUtils_getCustomersFromJSON() throws IOException {
		
		String path = "src/main/resources/testJson.txt";
		
		Customer c = new Customer(12L,"Christina McArdle",52.986375,-6.043701);
		
		List<Customer> actualList = FileUtils.getCustomersFromJSON(path);
		
		assertEquals(actualList.size(), 1);

		Customer actualCustomer = actualList.get(0);
		
		assertEquals(c.getName(), actualCustomer.getName());
		assertEquals(c.getLatitude(), actualCustomer.getLatitude());
		assertEquals(c.getLongitude(), actualCustomer.getLongitude());
		assertEquals(c.getUser_id(), actualCustomer.getUser_id());
	}
	
	public void test_fileUtils_getCustomersFromJSON_fail() {
		String wrongPath = "n/resources/testJson.txt";
		
		try{
			FileUtils.getCustomersFromJSON(wrongPath);
			fail();
		}
		catch(IOException e){
			assertEquals(e.getClass(), FileNotFoundException.class);
		}
	}
	

}
