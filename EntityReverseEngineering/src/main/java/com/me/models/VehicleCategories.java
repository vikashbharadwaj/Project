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
 * VehicleCategories generated by hbm2java
 */
@Entity
@Table(name="vehicle_categories"
    ,catalog="kemuvin"
)
public class VehicleCategories  implements java.io.Serializable {


     private Long vehicleCategoryId;
     private String vehicleCategory;
     private Set<Brands> brandses = new HashSet<Brands>(0);
     private Set<Models> modelses = new HashSet<Models>(0);

    public VehicleCategories() {
    }

    public VehicleCategories(String vehicleCategory, Set<Brands> brandses, Set<Models> modelses) {
       this.vehicleCategory = vehicleCategory;
       this.brandses = brandses;
       this.modelses = modelses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="vehicle_category_id", unique=true, nullable=false)
    public Long getVehicleCategoryId() {
        return this.vehicleCategoryId;
    }
    
    public void setVehicleCategoryId(Long vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    
    @Column(name="vehicle_category", length=100)
    public String getVehicleCategory() {
        return this.vehicleCategory;
    }
    
    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vehicleCategories")
    public Set<Brands> getBrandses() {
        return this.brandses;
    }
    
    public void setBrandses(Set<Brands> brandses) {
        this.brandses = brandses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vehicleCategories")
    public Set<Models> getModelses() {
        return this.modelses;
    }
    
    public void setModelses(Set<Models> modelses) {
        this.modelses = modelses;
    }




}


