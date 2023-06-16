package com.Demo.FoodCity.repo;

import com.Demo.FoodCity.entity.Customer;
import com.Demo.FoodCity.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,String> {
    @Query(value = "SELECT COUNT(item_code) FROM item WHERE itemName LIKE ?1 ", nativeQuery = true)
    public long getCountWithSearchText(String text);
    @Query (value = "SELECT * FROM item WHERE itemName LIKE ?1", nativeQuery = true)
    public Page<Item> findAllWithSearchText(String text, PageRequest request);
}
