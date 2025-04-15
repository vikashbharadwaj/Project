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
 * Users generated by hbm2java
 */
@Entity
@Table(name="users"
    ,catalog="kemuvin"
)
public class Users  implements java.io.Serializable {


     private Long userId;
     private Roles roles;
     private String firstName;
     private String lastName;
     private String email;
     private String password;
     private Long phoneNumber;
     private String expoNotificationToken;
     private Set<Vehicles> vehicleses = new HashSet<Vehicles>(0);
     private Set<UserSubscriptions> userSubscriptionses = new HashSet<UserSubscriptions>(0);

    public Users() {
    }

    public Users(Roles roles, String firstName, String lastName, String email, String password, Long phoneNumber, String expoNotificationToken, Set<Vehicles> vehicleses, Set<UserSubscriptions> userSubscriptionses) {
       this.roles = roles;
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.password = password;
       this.phoneNumber = phoneNumber;
       this.expoNotificationToken = expoNotificationToken;
       this.vehicleses = vehicleses;
       this.userSubscriptionses = userSubscriptionses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="user_id", unique=true, nullable=false)
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role_id")
    public Roles getRoles() {
        return this.roles;
    }
    
    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    
    @Column(name="first_name", length=100)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", length=100)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="email", length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="password", length=100)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="phone_number")
    public Long getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    @Column(name="expo_notification_token", length=100)
    public String getExpoNotificationToken() {
        return this.expoNotificationToken;
    }
    
    public void setExpoNotificationToken(String expoNotificationToken) {
        this.expoNotificationToken = expoNotificationToken;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<Vehicles> getVehicleses() {
        return this.vehicleses;
    }
    
    public void setVehicleses(Set<Vehicles> vehicleses) {
        this.vehicleses = vehicleses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<UserSubscriptions> getUserSubscriptionses() {
        return this.userSubscriptionses;
    }
    
    public void setUserSubscriptionses(Set<UserSubscriptions> userSubscriptionses) {
        this.userSubscriptionses = userSubscriptionses;
    }




}


