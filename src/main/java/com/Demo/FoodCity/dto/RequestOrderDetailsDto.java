package com.Demo.FoodCity.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestOrderDetailsDto {

    private double qty;
    private double price;
}

