package com.Demo.FoodCity.service;

import com.Demo.FoodCity.dto.RequestCustomerDto;
import com.Demo.FoodCity.dto.response.ResponseCustomerDto;
import com.Demo.FoodCity.paginated.PaginatedCustomerResponseDto;

public interface CustomerService {
    public void saveCustomer(RequestCustomerDto dto);
    public void updateCustomer(RequestCustomerDto dto, String id);
    public void deleteCustomer(String id);
    public ResponseCustomerDto findCustomer(String id);
    public PaginatedCustomerResponseDto findAllCustomer(int page, int size);

    public PaginatedCustomerResponseDto searchCustomer(int page, int size, String text);
}
