package com.Demo.FoodCity.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestOrderDto {
    private Date date;

    private String customerId;
    private int numOfItem;
    private double totalPrice;
}
