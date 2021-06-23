package com.example.Assignment4.controller;

import com.example.Assignment4.entity.Items;
import com.example.Assignment4.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Items> getById(@PathVariable final int id) {
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    /*
     * put method for adding row in db
     */
    @PutMapping("/item")
    public Items postItem(@RequestBody final Items item) {
        return  itemService.addItems(item);
    }


    /*
     * put method for updating row in db of given id
     */
    @PutMapping("/item/{id}")
    public ResponseEntity<Items> updateItemById(@RequestBody final Items item, @PathVariable final int id) {
        return itemService.getItemById(id)
                .map(itemObj ->{
                    itemObj.setId(id);
                    return ResponseEntity.ok(itemService.updateItem(itemObj,id));
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    /*
     * delete method for removing row from db of given id
     * @param id id of item
     */
    @DeleteMapping("/item/{id}")
    public ResponseEntity<Items> deleteById(@PathVariable final int id) {
        return itemService.getItemById(id)
                .map(itemObj ->{
                    itemService.deleteItemById(id);
                    return ResponseEntity.ok(itemObj);
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
