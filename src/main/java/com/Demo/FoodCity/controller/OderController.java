package com.Demo.FoodCity.controller;

import com.Demo.FoodCity.dto.RequestOrderDto;
import com.Demo.FoodCity.dto.response.ResponseOrderDto;
import com.Demo.FoodCity.paginated.PaginatedOrderResponseDto;
import com.Demo.FoodCity.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/v1/order")
public class OderController {
    final OrderService orderService;

    public OderController(OrderService orderService) {
        this.orderService = orderService;
    }

@PostMapping
    public String  saveOrder(RequestOrderDto dto){
        orderService.saveOrder(dto);
        return "Order Saved !";
    };
    @PutMapping(params = "code")
    public String  updateOrder(@RequestBody RequestOrderDto dto,@RequestParam String code){
        orderService.updateOrder(dto,code);
        return "Order Updated !";
    };
    @DeleteMapping(params = "code")
    public String  deleteOrder(@RequestParam String code){
        orderService.deleteOrder(code);
        return "Order Deleted !";
    };
    @GetMapping("/{code}")
    public ResponseOrderDto findOrder(@PathVariable String code){
        return orderService.findOrder(code);
    };
    @GetMapping(path = "/all", params = {"page", "size"})
    public PaginatedOrderResponseDto findAllOrder(@RequestParam int page,@RequestParam int size){
        return orderService.findAllOrder(page, size);
    };
    @GetMapping(path = "/search", params = {"page", "size", "date"})
    public PaginatedOrderResponseDto searchOrder(@RequestParam int page, @RequestParam int size, @RequestParam Date date){
        return orderService.searchOrder(page, size, date);
    };
}
