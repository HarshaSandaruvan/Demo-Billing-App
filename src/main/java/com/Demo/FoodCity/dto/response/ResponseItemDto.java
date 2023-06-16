package com.Demo.FoodCity.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseItemDto {
   private String item_code;

   private String itemName;
   private String description;
   private double qtyOnHand;
   private double price;

}
