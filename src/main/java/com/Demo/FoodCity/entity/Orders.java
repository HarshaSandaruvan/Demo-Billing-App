package com.Demo.FoodCity.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Orders {
    @Id
    private String order_id;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false, length = 50)
    private String customer_id;
    @Column(nullable = false,length = 10)
    private int numOfItems;
    @Column(nullable = false, length = 10)
    private double totalPrice;
}
