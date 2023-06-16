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
public class Customer {
    @Id
    private String customer_id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 250)
    private String address;
    @Column(nullable = false, length = 10)
    private int tpNumber;
}
