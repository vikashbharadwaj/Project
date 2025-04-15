package com.me.models;
// Generated Jan 6, 2025 12:39:00 PM by Hibernate Tools 4.0.1.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VendorServices generated by hbm2java
 */
@Entity
@Table(name="vendor_services"
    ,catalog="kemuvin"
)
public class VendorServices  implements java.io.Serializable {


     private Long vendorServiceId;
     private Vendors vendors;
     private Services services;

    public VendorServices() {
    }

    public VendorServices(Vendors vendors, Services services) {
       this.vendors = vendors;
       this.services = services;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="vendor_service_id", unique=true, nullable=false)
    public Long getVendorServiceId() {
        return this.vendorServiceId;
    }
    
    public void setVendorServiceId(Long vendorServiceId) {
        this.vendorServiceId = vendorServiceId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vendor_id", nullable=false)
    public Vendors getVendors() {
        return this.vendors;
    }
    
    public void setVendors(Vendors vendors) {
        this.vendors = vendors;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="service_id", nullable=false)
    public Services getServices() {
        return this.services;
    }
    
    public void setServices(Services services) {
        this.services = services;
    }




}


