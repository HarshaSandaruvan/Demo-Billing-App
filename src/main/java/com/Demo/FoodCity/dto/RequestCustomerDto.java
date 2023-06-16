package com.Demo.FoodCity.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestCustomerDto {

    private String name;
    private String address;
    private int tpNumber;
}
