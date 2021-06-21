package com.example.Assignment4.controller;

import com.example.Assignment4.entity.Items;
import com.example.Assignment4.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/*
 * It is use as rest controller
 */
@RestController
public class ItemController {

    @Autowired
    public ItemService itemService;

    /*
     * get method for fetching all row from db
     */
    @GetMapping("/items")
    public List<Items> getAllItem() {
        return itemService.getItems();
    }

    /*
     * get method for fetching row from db of given id
     */
    @GetMapping("/item/{id}")
    public Items getById(@PathVariable final String id) {
        return itemService.getItemById(id);
    }

    /*
     * put method for adding row in db
     */
    @PutMapping("/item")
    public void postItem(@RequestBody final Items item) {
        itemService.addItems(item);
    }


    /*
     * put method for updating row in db of given id
     */
    @PutMapping("/item/{id}")
    public void updateItemById(@RequestBody final Items item, @PathVariable final String id) {
        itemService.updateItem(item, id);
    }

    /*
     * delete method for removing row from db of given id
     */
    @DeleteMapping("/item/{id}")
    public void deleteById(@PathVariable final String id) {
        itemService.deleteItemById(id);
    }
}
