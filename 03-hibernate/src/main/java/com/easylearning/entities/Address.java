package com.easylearning.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name="STREET_NO")
	public String streetNo;
	public String city;
	
	@Column(name="LandMARK")
	public String landMark;
	
	public String zip;

	public Address() {
	}

	public Address(String streetNo, String city, String landMark, String zip) {
		super();
		this.streetNo = streetNo;
		this.city = city;
		this.landMark = landMark;
		this.zip = zip;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}