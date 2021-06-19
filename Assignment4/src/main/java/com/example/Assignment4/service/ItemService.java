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
