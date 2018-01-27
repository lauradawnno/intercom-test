package com.intercom.customer_test.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.intercom.customer_test.model.Customer;

public class FileUtils {

	/**
	 * Reads a list of Customers from a text file containing a JSON object on
	 * each line
	 * 
	 * @param path JSON file path
	 * @return list of Customer objects
	 * @throws IOException
	 */
	public static List<Customer> getCustomersFromJSON(String path) throws IOException {
		ArrayList<Customer> listC = new ArrayList<Customer>();
		BufferedReader in;

		in = new BufferedReader(new FileReader(path));
		Gson gson = new Gson();
		String line;

		while ((line = in.readLine()) != null) {
			Customer c = gson.fromJson(line, Customer.class);
			listC.add(c);
		}
		in.close();

		return listC;
	}

}
