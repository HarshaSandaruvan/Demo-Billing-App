package com.Demo.FoodCity.service.impl;

import com.Demo.FoodCity.dto.RequestCustomerDto;
import com.Demo.FoodCity.dto.response.ResponseCustomerDto;
import com.Demo.FoodCity.entity.Customer;
import com.Demo.FoodCity.paginated.PaginatedCustomerResponseDto;
import com.Demo.FoodCity.repo.CustomerRepo;
import com.Demo.FoodCity.service.CustomerService;
import com.Demo.FoodCity.util.IdManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    final CustomerRepo customerRepo;
    final IdManager idManager;

    public CustomerServiceImpl(@Lazy CustomerService customerService, CustomerRepo customerRepo, IdManager idManager) {
        this.customerRepo = customerRepo;
        this.idManager = idManager;
    }

    @Override
    public void saveCustomer(RequestCustomerDto dto) {
        Customer c = new Customer(
                idManager.generate(8, "C"),
                dto.getName(),
                dto.getAddress(),
                dto.getTpNumber()
        );
        customerRepo.save(c);
    }

    @Override
    public void updateCustomer(RequestCustomerDto dto, String id) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        Customer customer = selectedCustomer.get();
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setTpNumber(dto.getTpNumber());
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepo.deleteById(id);
    }

    @Override
    public ResponseCustomerDto findCustomer(String id) {
        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        Customer customer = selectedCustomer.get();
        return new ResponseCustomerDto(
                customer.getCustomer_id(),
                customer.getName(),
                customer.getAddress(),
                customer.getTpNumber()
        );
    }

    @Override
    public PaginatedCustomerResponseDto findAllCustomer(int page, int size) {
        long count = customerRepo.count();
        Page<Customer> all = customerRepo.findAll(PageRequest.of(page, size));
        List<ResponseCustomerDto> dtos = new ArrayList<>();
        for (Customer c : all
        ) {
            dtos.add(new ResponseCustomerDto(
                    c.getCustomer_id(),
                    c.getName(),
                    c.getAddress(),
                    c.getTpNumber()

            ));
        }
        return new PaginatedCustomerResponseDto(
                count, dtos
        );
    }

    @Override
    public PaginatedCustomerResponseDto searchCustomer(int page, int size, String text) {
        text = "%" + text + "%";
        long count = customerRepo.getCountWithSearchText(text);
        Page<Customer> all = customerRepo.findAllWithSearchText(text,PageRequest.of(page, size));
        List<ResponseCustomerDto> dtos = new ArrayList<>();
        for (Customer c : all
        ) {
            dtos.add(new ResponseCustomerDto(
                    c.getCustomer_id(),
                    c.getName(),
                    c.getAddress(),
                    c.getTpNumber()

            ));
        }
        return new PaginatedCustomerResponseDto(
                count, dtos
        );
    }
}
