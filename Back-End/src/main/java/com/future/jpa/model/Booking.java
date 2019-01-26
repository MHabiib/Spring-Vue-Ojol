package com.future.jpa.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
    public class Booking {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String memberName;
    private Integer memberId;
    private String driverName;
    private Integer driverId;
    private Double price;
    private String status="PENDING";
    private String pickup;
    private String dropoff;
    private String paymentMethod;
}

