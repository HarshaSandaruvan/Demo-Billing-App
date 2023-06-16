package com.Demo.FoodCity.dto.response;

import lombok.*;

import java.text.spi.DateFormatSymbolsProvider;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseOrderDto {
    private Date date;
    private String orderId;
    private String customerId;
    private int numOfItem;
    private double totalPrice;
}
