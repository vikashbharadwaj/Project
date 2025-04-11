package com.sowedid.studentdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class StudentAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addresId;
	 private String street;
	    private String city;
	    private String state;
	    private String country;
	    private String zipcode;
	    @OneToMany
	    private Student student;
		public Long getAddresId() {
			return addresId;
		}
		public void setAddresId(Long addresId) {
			this.addresId = addresId;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
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
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
	

	
}
