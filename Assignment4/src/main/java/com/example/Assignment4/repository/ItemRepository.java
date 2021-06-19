package com.example.Assignment4.repository;

import com.example.Assignment4.entity.Items;
import org.springframework.data.repository.CrudRepository;

/*
 * interface for item repository
 */
public interface ItemRepository extends CrudRepository<Items, String> {
}
