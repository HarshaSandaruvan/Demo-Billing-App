package com.Demo.FoodCity.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    @Id
    private String item_code;
    @Column(nullable = false, length = 50)
    private String itemName;
    @Column(nullable = false, length = 250)
    private String description;
    @Column(nullable = false, length = 10)
    private double qtyOnHand;
    @Column(nullable = false, length = 10)
    private double price;



}
