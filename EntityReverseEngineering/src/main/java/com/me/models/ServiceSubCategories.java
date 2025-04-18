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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ServiceSubCategories generated by hbm2java
 */
@Entity
@Table(name="service_sub_categories"
    ,catalog="kemuvin"
)
public class ServiceSubCategories  implements java.io.Serializable {


     private Integer serviceSubCategoryId;
     private ServicesCategories servicesCategories;
     private String serviceSubCategory;
     private Set<Services> serviceses = new HashSet<Services>(0);

    public ServiceSubCategories() {
    }

	
    public ServiceSubCategories(String serviceSubCategory) {
        this.serviceSubCategory = serviceSubCategory;
    }
    public ServiceSubCategories(ServicesCategories servicesCategories, String serviceSubCategory, Set<Services> serviceses) {
       this.servicesCategories = servicesCategories;
       this.serviceSubCategory = serviceSubCategory;
       this.serviceses = serviceses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="service_sub_category_id", unique=true, nullable=false)
    public Integer getServiceSubCategoryId() {
        return this.serviceSubCategoryId;
    }
    
    public void setServiceSubCategoryId(Integer serviceSubCategoryId) {
        this.serviceSubCategoryId = serviceSubCategoryId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="service_category_id")
    public ServicesCategories getServicesCategories() {
        return this.servicesCategories;
    }
    
    public void setServicesCategories(ServicesCategories servicesCategories) {
        this.servicesCategories = servicesCategories;
    }

    
    @Column(name="service_sub_category", nullable=false, length=100)
    public String getServiceSubCategory() {
        return this.serviceSubCategory;
    }
    
    public void setServiceSubCategory(String serviceSubCategory) {
        this.serviceSubCategory = serviceSubCategory;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="serviceSubCategories")
    public Set<Services> getServiceses() {
        return this.serviceses;
    }
    
    public void setServiceses(Set<Services> serviceses) {
        this.serviceses = serviceses;
    }




}


