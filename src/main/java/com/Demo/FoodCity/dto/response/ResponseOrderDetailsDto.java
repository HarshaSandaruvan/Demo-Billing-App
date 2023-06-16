package com.Demo.FoodCity.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseOrderDetailsDto {
   private String itemCode;
    private double qty;
    private double price;
}

