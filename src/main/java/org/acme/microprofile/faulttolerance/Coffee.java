package org.acme.microprofile.faulttolerance;

public class Coffee {
	public Integer id;
	public String name;
	public String countryOfOrigin;
	public Integer price;
	/**
	 * @param id
	 * @param name
	 * @param countryOfOrigin
	 * @param price
	 */
	public Coffee(Integer id, String name, String countryOfOrigin, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.countryOfOrigin = countryOfOrigin;
		this.price = price;
	}
	
	public Coffee() {
		
	}
}
