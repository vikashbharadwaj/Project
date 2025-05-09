package com.me.models;
// Generated Jan 6, 2025 12:39:00 PM by Hibernate Tools 4.0.1.Final


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VendorAcceptedBookings generated by hbm2java
 */
@Entity
@Table(name="vendor_accepted_bookings"
    ,catalog="kemuvin"
)
public class VendorAcceptedBookings  implements java.io.Serializable {


     private Long vendorAcceptedBookingId;
     private Bookings bookings;
     private Vendors vendors;
     private Boolean accepted;
     private Date acceptedDatetime;

    public VendorAcceptedBookings() {
    }

    public VendorAcceptedBookings(Bookings bookings, Vendors vendors, Boolean accepted, Date acceptedDatetime) {
       this.bookings = bookings;
       this.vendors = vendors;
       this.accepted = accepted;
       this.acceptedDatetime = acceptedDatetime;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="vendor_accepted_booking_id", unique=true, nullable=false)
    public Long getVendorAcceptedBookingId() {
        return this.vendorAcceptedBookingId;
    }
    
    public void setVendorAcceptedBookingId(Long vendorAcceptedBookingId) {
        this.vendorAcceptedBookingId = vendorAcceptedBookingId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="booking_id")
    public Bookings getBookings() {
        return this.bookings;
    }
    
    public void setBookings(Bookings bookings) {
        this.bookings = bookings;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vendor_id")
    public Vendors getVendors() {
        return this.vendors;
    }
    
    public void setVendors(Vendors vendors) {
        this.vendors = vendors;
    }

    
    @Column(name="accepted")
    public Boolean getAccepted() {
        return this.accepted;
    }
    
    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="accepted_datetime", length=19)
    public Date getAcceptedDatetime() {
        return this.acceptedDatetime;
    }
    
    public void setAcceptedDatetime(Date acceptedDatetime) {
        this.acceptedDatetime = acceptedDatetime;
    }




}


