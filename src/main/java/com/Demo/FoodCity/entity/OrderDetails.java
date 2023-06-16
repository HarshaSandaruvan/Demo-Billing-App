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
public class OrderDetails {
    @Id
    private String  itemCode;
    @Column(nullable = false)
    private double qty;
    @Column(nullable = false)
    private double price;
}
