package com.Demo.FoodCity.service;

import com.Demo.FoodCity.dto.response.ResponseItemDto;
import com.Demo.FoodCity.dto.response.ResponseOrderDetailsDto;
import com.Demo.FoodCity.dto.response.ResponseOrderDto;
import com.Demo.FoodCity.paginated.PaginatedOrderDetailsResponseDto;
import com.Demo.FoodCity.paginated.PaginatedOrderResponseDto;

public interface OrderDetailsService {
    public void saveOrderDetail(ResponseOrderDetailsDto dto);
        public void deleteOrderDetail(String code);
       public PaginatedOrderDetailsResponseDto findAllOrderDetails(int page, int size);

}
