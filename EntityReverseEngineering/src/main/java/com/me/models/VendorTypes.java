package com.me.models;
// Generated Jan 6, 2025 12:39:00 PM by Hibernate Tools 4.0.1.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * VendorTypes generated by hbm2java
 */
@Entity
@Table(name="vendor_types"
    ,catalog="kemuvin"
)
public class VendorTypes  implements java.io.Serializable {


     private Integer vendorTypeId;
     private String vendorType;
     private Set<Vendors> vendorses = new HashSet<Vendors>(0);

    public VendorTypes() {
    }

    public VendorTypes(String vendorType, Set<Vendors> vendorses) {
       this.vendorType = vendorType;
       this.vendorses = vendorses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="vendor_type_id", unique=true, nullable=false)
    public Integer getVendorTypeId() {
        return this.vendorTypeId;
    }
    
    public void setVendorTypeId(Integer vendorTypeId) {
        this.vendorTypeId = vendorTypeId;
    }

    
    @Column(name="vendor_type", length=100)
    public String getVendorType() {
        return this.vendorType;
    }
    
    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vendorTypes")
    public Set<Vendors> getVendorses() {
        return this.vendorses;
    }
    
    public void setVendorses(Set<Vendors> vendorses) {
        this.vendorses = vendorses;
    }




}


