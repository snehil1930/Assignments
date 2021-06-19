package com.example.Assignment4.service;

import com.example.Assignment4.constants.MessageConstants;
import com.example.Assignment4.constants.ValueConstants;
import com.example.Assignment4.entity.Items;
import com.example.Assignment4.entity.ItemsBuilder;
import com.example.Assignment4.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/*
 * service class of project
 */
@Service
public class ItemService {

    /*
     * autowiring of item repo
     */
    @Autowired
    public ItemRepository itemRepository;
    /*
     * lock used is ReentrantLock
     */
    private final ReentrantLock lock = new ReentrantLock();

    /*
     * service to fetch list of rows from db
     * @return List of items
     */
    @Async("taskExecutor")
    public List<Items> getItems() {
        lock.lock();
        try {
            System.out.println(MessageConstants.GETMESSAGE + Thread.currentThread().getName());
            return (List<Items>) itemRepository.findAll();
        } finally {
            lock.unlock();
        }
    }

    /*
     * service to fetch item of given id of rows from db
     * @param id id of item
     * @return item
     */
    @Async("taskExecutor")
    public Items getItemById(final String id) {
        lock.lock();
        try {
            System.out.println(MessageConstants.GETMESSAGE + Thread.currentThread().getName());
            return itemRepository.findById(id).get();
        } finally {
            lock.unlock();
        }
    }

    /*
     * service to add rows in db
     * @param items of the items
     */
    @Async("taskExecutor")
    public void addItems(final Items item) {
        lock.lock();
        try {
            System.out.println(MessageConstants.PUTMESSAGE + Thread.currentThread().getName());
            itemRepository.save(new ItemsBuilder(item.getId(), item.getName(),
                    item.getPrice(), item.getQuantity(), item.getType()).getItem());
        } finally {
            lock.unlock();
        }
    }

    /*
     * service to update rows in db
     * @param  items of class Items
     * @param  id of items
     * @return items
     */
    @Async("taskExecutor")
    public Items updateItem(final Items item, final String id) {
        lock.lock();
        try {
            System.out.println(MessageConstants.PUTMESSAGE + Thread.currentThread().getName());
            itemRepository.save(new ItemsBuilder(item.getId(), item.getName(),
                    item.getPrice(), item.getQuantity(), item.getType()).getItem());
            return itemRepository.findById(id).get();
        } finally {
            lock.unlock();
        }
    }


    /*
     * service to delete ro from db
     * @param id to be deleteted
     */
    @Async("taskExecutor")
    public void deleteItemById(final String id) {
        lock.lock();
        try {
            System.out.println(MessageConstants.DELETMESSAGE + Thread.currentThread().getName());
            itemRepository.deleteById(id);
        } finally {
            lock.unlock();
        }
    }

    /*
     * method to add item in db through thread
     */
    @Async("taskExecutor")
    public void producer() {

        for (int i = ValueConstants.ZERO; i < ValueConstants.HUNDRED; i++) {
            addItems(new ItemsBuilder
                    ("2", "wood", 23.4f, 2, "raw").getItem());
        }
    }

    @Async("taskExecutor")
    public void consumer() {
        for (int i = ValueConstants.ZERO; i < ValueConstants.HUNDRED; i++) {
            getItemById("2");
        }
    }


}
