package com.alayon.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alayon.unittesting.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
