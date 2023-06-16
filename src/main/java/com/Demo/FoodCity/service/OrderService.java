package com.Demo.FoodCity.service;

import com.Demo.FoodCity.dto.RequestItemDto;
import com.Demo.FoodCity.dto.RequestOrderDto;
import com.Demo.FoodCity.dto.response.ResponseItemDto;
import com.Demo.FoodCity.dto.response.ResponseOrderDto;
import com.Demo.FoodCity.paginated.PaginatedItemResponseDto;
import com.Demo.FoodCity.paginated.PaginatedOrderResponseDto;

import java.util.Date;

public interface OrderService {
    public void saveOrder(RequestOrderDto dto);
    public void updateOrder(RequestOrderDto dto, String code);
    public void deleteOrder(String code);
    public ResponseOrderDto findOrder(String code);
    public PaginatedOrderResponseDto findAllOrder(int page, int size);

    PaginatedOrderResponseDto searchOrder(int page, int size, Date date);
}
