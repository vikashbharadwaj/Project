package com.me.models;
// Generated Jan 6, 2025 12:39:00 PM by Hibernate Tools 4.0.1.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Addresses generated by hbm2java
 */
@Entity
@Table(name="addresses"
    ,catalog="kemuvin"
)
public class Addresses  implements java.io.Serializable {


     private Long addressId;
     private String street;
     private String village;
     private String mandal;
     private String district;
     private String city;
     private Long pinCode;
     private String state;
     private long userId;
     private String formattedAddress;
     private String streetNumber;
     private String subregion;
     private String timezone;
     private String isoCountryCode;
     private String name;
     private String latitude;
     private String longitude;
     private String parking;

    public Addresses() {
    }

	
    public Addresses(long userId) {
        this.userId = userId;
    }
    public Addresses(String street, String village, String mandal, String district, String city, Long pinCode, String state, long userId, String formattedAddress, String streetNumber, String subregion, String timezone, String isoCountryCode, String name, String latitude, String longitude, String parking) {
       this.street = street;
       this.village = village;
       this.mandal = mandal;
       this.district = district;
       this.city = city;
       this.pinCode = pinCode;
       this.state = state;
       this.userId = userId;
       this.formattedAddress = formattedAddress;
       this.streetNumber = streetNumber;
       this.subregion = subregion;
       this.timezone = timezone;
       this.isoCountryCode = isoCountryCode;
       this.name = name;
       this.latitude = latitude;
       this.longitude = longitude;
       this.parking = parking;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="address_id", unique=true, nullable=false)
    public Long getAddressId() {
        return this.addressId;
    }
    
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    
    @Column(name="street", length=100)
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    
    @Column(name="village", length=100)
    public String getVillage() {
        return this.village;
    }
    
    public void setVillage(String village) {
        this.village = village;
    }

    
    @Column(name="mandal", length=100)
    public String getMandal() {
        return this.mandal;
    }
    
    public void setMandal(String mandal) {
        this.mandal = mandal;
    }

    
    @Column(name="district", length=100)
    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }

    
    @Column(name="city", length=100)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="pin_code")
    public Long getPinCode() {
        return this.pinCode;
    }
    
    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }

    
    @Column(name="state", length=100)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    
    @Column(name="user_id", nullable=false)
    public long getUserId() {
        return this.userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }

    
    @Column(name="formatted_address", length=65535)
    public String getFormattedAddress() {
        return this.formattedAddress;
    }
    
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    
    @Column(name="street_number", length=100)
    public String getStreetNumber() {
        return this.streetNumber;
    }
    
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    
    @Column(name="subregion", length=100)
    public String getSubregion() {
        return this.subregion;
    }
    
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    
    @Column(name="timezone", length=100)
    public String getTimezone() {
        return this.timezone;
    }
    
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    
    @Column(name="iso_country_code", length=100)
    public String getIsoCountryCode() {
        return this.isoCountryCode;
    }
    
    public void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
    }

    
    @Column(name="name", length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="latitude", length=100)
    public String getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    
    @Column(name="longitude", length=100)
    public String getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    
    @Column(name="parking", length=16777215)
    public String getParking() {
        return this.parking;
    }
    
    public void setParking(String parking) {
        this.parking = parking;
    }




}


