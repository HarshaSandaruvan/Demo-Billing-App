package com.Demo.FoodCity.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseCustomerDto {
    private String customer_id;
    private String name;
    private String address;
    private int tpNUmber;
}
