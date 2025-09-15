package com.lcwd.rating.RatingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedBack;

//    @PrePersist
//    public void generateId() {
//        this.ratingId = UUID.randomUUID().toString();
//    }

}
