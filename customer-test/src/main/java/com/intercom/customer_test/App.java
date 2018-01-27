package com.intercom.customer_test;

import java.io.IOException;
import java.util.List;

import com.intercom.customer_test.model.Customer;
import com.intercom.customer_test.utils.FileUtils;
import com.intercom.customer_test.utils.GeoUtils;


public class App {

	public static void main(String[] args) throws IOException {

		List<Customer> listC = FileUtils.getCustomersFromJSON("src/main/resources/gistfile1.txt");

		listC.stream()
			 .filter(c -> GeoUtils.getDistance(c.getLatitude(), c.getLongitude()) <= 100)
			 .sorted()
			 .forEach(c -> System.out.println("UserId: " + c.getUser_id() + " Name: " + c.getName()));

	}

}
