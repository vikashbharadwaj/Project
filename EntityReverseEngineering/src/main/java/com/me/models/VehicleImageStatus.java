package com.me.models;
// Generated Jan 6, 2025 12:39:00 PM by Hibernate Tools 4.0.1.Final


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VehicleImageStatus generated by hbm2java
 */
@Entity
@Table(name="vehicle_image_status"
    ,catalog="kemuvin"
)
public class VehicleImageStatus  implements java.io.Serializable {


     private Long vehicleImageStatusId;
     private VehicleViewTypes vehicleViewTypes;
     private String imageNameBefore;
     private String imageNameAfter;
     private String imagePathBefore;
     private String imagePathAfter;
     private Date imageDatetimeBefore;
     private Date imageDatetimeAfter;
     private Set<BookingTracking> bookingTrackings = new HashSet<BookingTracking>(0);

    public VehicleImageStatus() {
    }

    public VehicleImageStatus(VehicleViewTypes vehicleViewTypes, String imageNameBefore, String imageNameAfter, String imagePathBefore, String imagePathAfter, Date imageDatetimeBefore, Date imageDatetimeAfter, Set<BookingTracking> bookingTrackings) {
       this.vehicleViewTypes = vehicleViewTypes;
       this.imageNameBefore = imageNameBefore;
       this.imageNameAfter = imageNameAfter;
       this.imagePathBefore = imagePathBefore;
       this.imagePathAfter = imagePathAfter;
       this.imageDatetimeBefore = imageDatetimeBefore;
       this.imageDatetimeAfter = imageDatetimeAfter;
       this.bookingTrackings = bookingTrackings;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="vehicle_image_status_id", unique=true, nullable=false)
    public Long getVehicleImageStatusId() {
        return this.vehicleImageStatusId;
    }
    
    public void setVehicleImageStatusId(Long vehicleImageStatusId) {
        this.vehicleImageStatusId = vehicleImageStatusId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vehicle_view_type_id")
    public VehicleViewTypes getVehicleViewTypes() {
        return this.vehicleViewTypes;
    }
    
    public void setVehicleViewTypes(VehicleViewTypes vehicleViewTypes) {
        this.vehicleViewTypes = vehicleViewTypes;
    }

    
    @Column(name="image_name_before", length=100)
    public String getImageNameBefore() {
        return this.imageNameBefore;
    }
    
    public void setImageNameBefore(String imageNameBefore) {
        this.imageNameBefore = imageNameBefore;
    }

    
    @Column(name="image_name_after", length=100)
    public String getImageNameAfter() {
        return this.imageNameAfter;
    }
    
    public void setImageNameAfter(String imageNameAfter) {
        this.imageNameAfter = imageNameAfter;
    }

    
    @Column(name="image_path_before", length=100)
    public String getImagePathBefore() {
        return this.imagePathBefore;
    }
    
    public void setImagePathBefore(String imagePathBefore) {
        this.imagePathBefore = imagePathBefore;
    }

    
    @Column(name="image_path_after", length=100)
    public String getImagePathAfter() {
        return this.imagePathAfter;
    }
    
    public void setImagePathAfter(String imagePathAfter) {
        this.imagePathAfter = imagePathAfter;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="image_datetime_before", length=19)
    public Date getImageDatetimeBefore() {
        return this.imageDatetimeBefore;
    }
    
    public void setImageDatetimeBefore(Date imageDatetimeBefore) {
        this.imageDatetimeBefore = imageDatetimeBefore;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="image_datetime_after", length=19)
    public Date getImageDatetimeAfter() {
        return this.imageDatetimeAfter;
    }
    
    public void setImageDatetimeAfter(Date imageDatetimeAfter) {
        this.imageDatetimeAfter = imageDatetimeAfter;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vehicleImageStatus")
    public Set<BookingTracking> getBookingTrackings() {
        return this.bookingTrackings;
    }
    
    public void setBookingTrackings(Set<BookingTracking> bookingTrackings) {
        this.bookingTrackings = bookingTrackings;
    }




}


