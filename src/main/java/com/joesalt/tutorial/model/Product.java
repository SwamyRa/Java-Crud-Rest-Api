package com.joesalt.tutorial.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "product_inventory")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private int price;

    @Column(name = "createdOn")
    private Timestamp createdOn;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "modifiedOn")
    private Timestamp modifiedOn;

    @Column(name = "modifiedBy")
    private String modifiedBy;
}
