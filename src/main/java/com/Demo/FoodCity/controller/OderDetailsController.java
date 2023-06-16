package com.Demo.FoodCity.controller;

import com.Demo.FoodCity.dto.response.ResponseOrderDetailsDto;
import com.Demo.FoodCity.dto.response.ResponseOrderDto;
import com.Demo.FoodCity.paginated.PaginatedOrderDetailsResponseDto;
import com.Demo.FoodCity.paginated.PaginatedOrderResponseDto;
import com.Demo.FoodCity.service.OrderDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order-detals")
public class OderDetailsController {
    final OrderDetailsService orderDetailsService;

    public OderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }


    @PostMapping
    public String  saveOrderDetails(ResponseOrderDetailsDto dto){
        orderDetailsService.saveOrderDetail(dto);
        return "Order Saved !";
    };
    @PutMapping(params = "code")

    @DeleteMapping(params = "code")
    public String  deleteOrder(@RequestParam String code){
        orderDetailsService.deleteOrderDetail(code);
        return "Order Deleted !";
    };

    @PostMapping(path = "/all", params = {"page", "size"})
    public PaginatedOrderDetailsResponseDto findAllOrder(@RequestParam int page, @RequestParam int size){
        return orderDetailsService.findAllOrderDetails(page, size);
    };
}
