package com.Demo.FoodCity.controller;

import com.Demo.FoodCity.dto.RequestCustomerDto;
import com.Demo.FoodCity.dto.response.ResponseCustomerDto;
import com.Demo.FoodCity.paginated.PaginatedCustomerResponseDto;
import com.Demo.FoodCity.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public String saveCustomer(RequestCustomerDto dto) {
        customerService.saveCustomer(dto);
        return "Saved !";
    }

    @GetMapping("/{id}")
    public ResponseCustomerDto findCustomer(@PathVariable String id) {
        return customerService.findCustomer(id);

    }

    @DeleteMapping(params = "id")
    public String deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return "Customer delete ";
    }

    @PutMapping(params = "id")
    public String updateCustomer(@RequestBody RequestCustomerDto dto, @RequestParam String id) {
        customerService.updateCustomer(dto, id);
        return "Customer update ";
    }

    @GetMapping(path = "/all", params = {"page", "size"})
    public PaginatedCustomerResponseDto findAllCustomer(@RequestParam int page, @RequestParam int size) {
       return customerService.findAllCustomer(page, size);

    }
    @GetMapping(path = "/search", params = {"page", "size", "text"})
    public PaginatedCustomerResponseDto searchCustomer(@RequestParam int page, @RequestParam int size, @RequestParam String text) {
        return customerService.searchCustomer(page, size,text);

    }

}
