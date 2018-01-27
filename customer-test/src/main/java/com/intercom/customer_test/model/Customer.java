package com.intercom.customer_test.model;

/**
 * A classic POJO with natural ordering 
 *
 */
public class Customer implements Comparable<Customer> {
	
	private Long user_id;
	
	private String name;
	
	private Double latitude;
	
	private Double longitude;
	
	

	public Customer(Long user_id, String name, Double latitude, Double longitude) {
		this.user_id = user_id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Override
	public int compareTo(Customer o) {
		if(this.user_id < o.getUser_id()) return -1;
		else if(this.user_id > o.getUser_id()) return 1;
		else return 0;
	}


	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
