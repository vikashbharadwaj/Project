package net.java.springboot.dto;

public class Adressdto {
	
	 private String adressName;
     private String addressType;
     private String adressLocation;
     private String adressCity;
     public Adressdto(String adressName, String addressType, String adressLocation, String adressCity) {
 		super();
 		this.adressName = adressName;
 		this.addressType = addressType;
 		this.adressLocation = adressLocation;
 		this.adressCity = adressCity;
 	}
	
	
	public Adressdto() {
	
	}

	public String getAdressName() {
		return adressName;
	}
	public void setAdressName(String adressName) {
		this.adressName = adressName;
	}
	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAdressLocation() {
		return adressLocation;
	}
	public void setAdressLocation(String adressLocation) {
		this.adressLocation = adressLocation;
	}

	public String getAdressCity() {
		return adressCity;
	}

	public void setAdressCity(String adressCity) {
		this.adressCity = adressCity;
	}
	
     

}
