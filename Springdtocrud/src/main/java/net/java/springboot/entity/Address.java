package net.java.springboot.entity;
// Generated 08-Jan-2025, 3:14:45 pm by Hibernate Tools 4.0.1.Final




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name="address")
   // ,catalog="reverse"

public class Address  implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy=GenerationType.SEQUENCE)
     private int addressId;
     private String adressName;
     private String addressType;
     private String adressLocation;
     private String adressCity;

    public Address() {
    }

	
    public Address(int addressId) {
        this.addressId = addressId;
    }
    public Address(int addressId, String adressName, String addressType, String adressLocation, String adressCity) {
       this.addressId = addressId;
       this.adressName = adressName;
       this.addressType = addressType;
       this.adressLocation = adressLocation;
       this.adressCity = adressCity;
    }
   
     @org.springframework.data.annotation.Id 

    
    @Column(name="address_id", unique=true, nullable=false)
    public int getAddressId() {
        return this.addressId;
    }
    
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    
    @Column(name="adress_name", length=40)
    public String getAdressName() {
        return this.adressName;
    }
    
    public void setAdressName(String adressName) {
        this.adressName = adressName;
    }

    
    @Column(name="address_type", length=5)
    public String getAddressType() {
        return this.addressType;
    }
    
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    
    @jakarta.persistence.Column(name="adress_location", length=30)
    public String getAdressLocation() {
        return this.adressLocation;
    }
    
    public void setAdressLocation(String adressLocation) {
        this.adressLocation = adressLocation;
    }
    public String getAdressCity() {
        return this.adressCity;
    }
    
    public void setAdressCity(String adressCity) {
        this.adressCity = adressCity;
    }




}


