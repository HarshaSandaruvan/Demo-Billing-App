package com.Demo.FoodCity.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestItemDto {
   private String itemName;
   private String description;
   private double qtyOnHand;
   private double price;

}
