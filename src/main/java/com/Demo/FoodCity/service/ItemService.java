package com.Demo.FoodCity.service;

import com.Demo.FoodCity.dto.RequestCustomerDto;
import com.Demo.FoodCity.dto.RequestItemDto;
import com.Demo.FoodCity.dto.response.ResponseItemDto;
import com.Demo.FoodCity.paginated.PaginatedCustomerResponseDto;
import com.Demo.FoodCity.paginated.PaginatedItemResponseDto;

public interface ItemService {
    public void saveItem(RequestItemDto dto);
    public void updateItem(RequestItemDto dto, String code);
    public void deleteItem(String code);
    public ResponseItemDto findItem(String code);
    public PaginatedItemResponseDto findAllItems(int page, int size);

    PaginatedItemResponseDto SearchItem(String text, int page, int size);
}
