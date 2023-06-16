package com.Demo.FoodCity.service.impl;

import com.Demo.FoodCity.dto.response.ResponseOrderDetailsDto;
import com.Demo.FoodCity.entity.OrderDetails;
import com.Demo.FoodCity.paginated.PaginatedOrderDetailsResponseDto;
import com.Demo.FoodCity.paginated.PaginatedOrderResponseDto;
import com.Demo.FoodCity.repo.OrderDetailsRepo;
import com.Demo.FoodCity.service.OrderDetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    final OrderDetailsRepo orderDetailsRepo;

    public OrderDetailsServiceImpl(OrderDetailsRepo orderDetailsRepo) {
        this.orderDetailsRepo = orderDetailsRepo;
    }


    @Override
    public void saveOrderDetail(ResponseOrderDetailsDto dto) {
        OrderDetails od = new OrderDetails(
                dto.getItemCode(),
                dto.getQty(),
                dto.getPrice()

        );
        orderDetailsRepo.save(od);
    }

    @Override
    public void deleteOrderDetail(String code) {
        orderDetailsRepo.deleteById(code);
    }

    @Override
    public PaginatedOrderDetailsResponseDto findAllOrderDetails(int page, int size) {
        long count = orderDetailsRepo.count();
        Page<OrderDetails> all = orderDetailsRepo.findAll(PageRequest.of(page, size));
        List<ResponseOrderDetailsDto> dtos = new ArrayList<>();
        for (OrderDetails od : all
        ) {
            dtos.add(
                    new ResponseOrderDetailsDto(
                            od.getItemCode(),
                            od.getQty(),
                            od.getPrice()
                    )
            );
        }
        return new PaginatedOrderDetailsResponseDto(
                count,dtos
        );

    }
}
