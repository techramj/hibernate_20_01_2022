package com.easylearing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EMP_LOCATIONS")
public class Location {
	
	@Id
	@Column(name="LOCATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loc_seq")
	@SequenceGenerator(name="loc_seq", sequenceName = "SEQ_EMP_LOC_ID")
	private Long locationId;
	
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE_PROVINCE")
	private String state;
	
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;
	
    public Location() {
		// TODO Auto-generated constructor stub
	}

	public Location(String streetAddress, String postalCode, String city, String state, Country country) {
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
    
}
