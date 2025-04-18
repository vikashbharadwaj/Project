package com.me.models;
// Generated Jan 6, 2025 12:39:00 PM by Hibernate Tools 4.0.1.Final


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserConfirmedBookingsId generated by hbm2java
 */
@Embeddable
public class UserConfirmedBookingsId  implements java.io.Serializable {


     private long bookingId;
     private Date startDate;
     private Date startTime;
     private int subscriptionPlanId;
     private String subscriptionName;
     private Long price;
     private long userId;
     private long vehicleId;
     private String vehicleNumber;
     private String formattedAddress;
     private String brandName;
     private String modelName;

    public UserConfirmedBookingsId() {
    }

	
    public UserConfirmedBookingsId(long bookingId, int subscriptionPlanId, long userId, long vehicleId, String modelName) {
        this.bookingId = bookingId;
        this.subscriptionPlanId = subscriptionPlanId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.modelName = modelName;
    }
    public UserConfirmedBookingsId(long bookingId, Date startDate, Date startTime, int subscriptionPlanId, String subscriptionName, Long price, long userId, long vehicleId, String vehicleNumber, String formattedAddress, String brandName, String modelName) {
       this.bookingId = bookingId;
       this.startDate = startDate;
       this.startTime = startTime;
       this.subscriptionPlanId = subscriptionPlanId;
       this.subscriptionName = subscriptionName;
       this.price = price;
       this.userId = userId;
       this.vehicleId = vehicleId;
       this.vehicleNumber = vehicleNumber;
       this.formattedAddress = formattedAddress;
       this.brandName = brandName;
       this.modelName = modelName;
    }
   


    @Column(name="booking_id", nullable=false)
    public long getBookingId() {
        return this.bookingId;
    }
    
    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }


    @Column(name="start_date", length=10)
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    @Column(name="start_time", length=8)
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    @Column(name="subscription_plan_id", nullable=false)
    public int getSubscriptionPlanId() {
        return this.subscriptionPlanId;
    }
    
    public void setSubscriptionPlanId(int subscriptionPlanId) {
        this.subscriptionPlanId = subscriptionPlanId;
    }


    @Column(name="subscription_name", length=100)
    public String getSubscriptionName() {
        return this.subscriptionName;
    }
    
    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }


    @Column(name="price", precision=10, scale=0)
    public Long getPrice() {
        return this.price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }


    @Column(name="user_id", nullable=false)
    public long getUserId() {
        return this.userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }


    @Column(name="vehicle_id", nullable=false)
    public long getVehicleId() {
        return this.vehicleId;
    }
    
    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }


    @Column(name="vehicle_number", length=100)
    public String getVehicleNumber() {
        return this.vehicleNumber;
    }
    
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }


    @Column(name="formatted_address", length=65535)
    public String getFormattedAddress() {
        return this.formattedAddress;
    }
    
    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }


    @Column(name="brand_name", length=100)
    public String getBrandName() {
        return this.brandName;
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


    @Column(name="model_name", nullable=false, length=100)
    public String getModelName() {
        return this.modelName;
    }
    
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserConfirmedBookingsId) ) return false;
		 UserConfirmedBookingsId castOther = ( UserConfirmedBookingsId ) other; 
         
		 return (this.getBookingId()==castOther.getBookingId())
 && ( (this.getStartDate()==castOther.getStartDate()) || ( this.getStartDate()!=null && castOther.getStartDate()!=null && this.getStartDate().equals(castOther.getStartDate()) ) )
 && ( (this.getStartTime()==castOther.getStartTime()) || ( this.getStartTime()!=null && castOther.getStartTime()!=null && this.getStartTime().equals(castOther.getStartTime()) ) )
 && (this.getSubscriptionPlanId()==castOther.getSubscriptionPlanId())
 && ( (this.getSubscriptionName()==castOther.getSubscriptionName()) || ( this.getSubscriptionName()!=null && castOther.getSubscriptionName()!=null && this.getSubscriptionName().equals(castOther.getSubscriptionName()) ) )
 && ( (this.getPrice()==castOther.getPrice()) || ( this.getPrice()!=null && castOther.getPrice()!=null && this.getPrice().equals(castOther.getPrice()) ) )
 && (this.getUserId()==castOther.getUserId())
 && (this.getVehicleId()==castOther.getVehicleId())
 && ( (this.getVehicleNumber()==castOther.getVehicleNumber()) || ( this.getVehicleNumber()!=null && castOther.getVehicleNumber()!=null && this.getVehicleNumber().equals(castOther.getVehicleNumber()) ) )
 && ( (this.getFormattedAddress()==castOther.getFormattedAddress()) || ( this.getFormattedAddress()!=null && castOther.getFormattedAddress()!=null && this.getFormattedAddress().equals(castOther.getFormattedAddress()) ) )
 && ( (this.getBrandName()==castOther.getBrandName()) || ( this.getBrandName()!=null && castOther.getBrandName()!=null && this.getBrandName().equals(castOther.getBrandName()) ) )
 && ( (this.getModelName()==castOther.getModelName()) || ( this.getModelName()!=null && castOther.getModelName()!=null && this.getModelName().equals(castOther.getModelName()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getBookingId();
         result = 37 * result + ( getStartDate() == null ? 0 : this.getStartDate().hashCode() );
         result = 37 * result + ( getStartTime() == null ? 0 : this.getStartTime().hashCode() );
         result = 37 * result + this.getSubscriptionPlanId();
         result = 37 * result + ( getSubscriptionName() == null ? 0 : this.getSubscriptionName().hashCode() );
         result = 37 * result + ( getPrice() == null ? 0 : this.getPrice().hashCode() );
         result = 37 * result + (int) this.getUserId();
         result = 37 * result + (int) this.getVehicleId();
         result = 37 * result + ( getVehicleNumber() == null ? 0 : this.getVehicleNumber().hashCode() );
         result = 37 * result + ( getFormattedAddress() == null ? 0 : this.getFormattedAddress().hashCode() );
         result = 37 * result + ( getBrandName() == null ? 0 : this.getBrandName().hashCode() );
         result = 37 * result + ( getModelName() == null ? 0 : this.getModelName().hashCode() );
         return result;
   }   


}


