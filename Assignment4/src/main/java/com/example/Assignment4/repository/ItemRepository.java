package com.example.Assignment4.repository;

import com.example.Assignment4.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;


/*
 * interface for item repository
 */
public interface ItemRepository extends JpaRepository<Items, Integer> {
}
