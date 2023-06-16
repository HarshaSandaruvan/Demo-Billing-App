package com.Demo.FoodCity.repo;

import com.Demo.FoodCity.entity.Item;
import com.Demo.FoodCity.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Orders, String> {
    @Query(value = "SELECT COUNT(order_id) FROM orders WHERE date LIKE ?1 ", nativeQuery = true)
    public long getCountWithSearchText(Date date);
    @Query (value = "SELECT * FROM orders WHERE date LIKE ?1", nativeQuery = true)
    public Page<Orders> findAllWithSearchText(Date date, PageRequest request);
}
