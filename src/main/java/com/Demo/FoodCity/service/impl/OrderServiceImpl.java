package com.Demo.FoodCity.service.impl;

import com.Demo.FoodCity.dto.RequestOrderDto;
import com.Demo.FoodCity.dto.response.ResponseOrderDetailsDto;
import com.Demo.FoodCity.dto.response.ResponseOrderDto;
import com.Demo.FoodCity.entity.OrderDetails;
import com.Demo.FoodCity.entity.Orders;
import com.Demo.FoodCity.paginated.PaginatedOrderDetailsResponseDto;
import com.Demo.FoodCity.paginated.PaginatedOrderResponseDto;
import com.Demo.FoodCity.repo.OrderRepo;
import com.Demo.FoodCity.service.OrderService;
import com.Demo.FoodCity.util.IdManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    final OrderRepo orderRepo;
    final IdManager idManager;

    public OrderServiceImpl(OrderRepo orderRepo, IdManager idManager) {
        this.orderRepo = orderRepo;
        this.idManager = idManager;
    }

    @Override
    public void saveOrder(RequestOrderDto dto) {
        Orders o = new Orders(
                idManager.generate(5, "Or"),
                dto.getDate(),
                dto.getCustomerId(),
                dto.getNumOfItem(),
                dto.getTotalPrice()
        );
        orderRepo.save(o);
    }


    @Override
    public void updateOrder(RequestOrderDto dto, String code) {
        Optional<Orders> selectedorder = orderRepo.findById(code);
        if (selectedorder.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Orders orders = selectedorder.get();

        orders.setDate(dto.getDate());
        orders.setCustomer_id(dto.getCustomerId());
        orders.setTotalPrice(dto.getTotalPrice());
        orders.setNumOfItems(dto.getNumOfItem());
        orderRepo.save(orders);
    }

    @Override
    public void deleteOrder(String code) {
        orderRepo.deleteById(code);
    }

    @Override
    public ResponseOrderDto findOrder(String code) {
        Optional<Orders> selectedorder = orderRepo.findById(code);
        if (selectedorder.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Orders orders = selectedorder.get();
        return new ResponseOrderDto(
                orders.getDate(),
                orders.getOrder_id(),
                orders.getCustomer_id(),
                orders.getNumOfItems(),
                orders.getTotalPrice()
        );

    }

    @Override
    public PaginatedOrderResponseDto findAllOrder(int page, int size) {
        long count = orderRepo.count();
        Page<Orders> all = orderRepo.findAll(PageRequest.of(page, size));
        List<ResponseOrderDto> dtos = new ArrayList<>();
        for (Orders o : all
        ) {
            dtos.add(
                    new ResponseOrderDto(
                            o.getDate(),
                            o.getOrder_id(),
                            o.getCustomer_id(),
                            o.getNumOfItems(),
                            o.getTotalPrice()
                    )
                    );
        }
        return new PaginatedOrderResponseDto(
                count,dtos
        );
    }

    @Override
    public PaginatedOrderResponseDto searchOrder(int page, int size, Date date) {
        date=new Date();
        long count = orderRepo.getCountWithSearchText(date);
        Page<Orders> all = orderRepo.findAllWithSearchText(date,PageRequest.of(page, size));
        List<ResponseOrderDto> dtos = new ArrayList<>();
        for (Orders o : all
        ) {
            dtos.add(
                    new ResponseOrderDto(
                            o.getDate(),
                            o.getOrder_id(),
                            o.getCustomer_id(),
                            o.getNumOfItems(),
                            o.getTotalPrice()
                    )
            );
        }
        return new PaginatedOrderResponseDto(
                count,dtos
        );

    }
}
