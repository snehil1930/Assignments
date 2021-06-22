package com.example.Assignment4;


import com.example.Assignment4.entity.Items;
import com.example.Assignment4.entity.ItemsBuilder;
import com.example.Assignment4.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



/*
 * It is use to test CRUD operation in database
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemTest {

    /*
     *injection of item repository
     */
    @Autowired
    private ItemRepository itemRepository;

    /*
     * It creates the row of data in datacase
     */
    @Test
    @Rollback(value = false)
    public void createItemTest() {
        Items item = new ItemsBuilder(1, "fruit", 23.4f, 5, "raw").getItem();
        Items savedItems = itemRepository.save(item);
        assertNotNull(savedItems);
        assertThat(savedItems.getName()).isEqualTo("fruit");
    }

    /*
     * Read operation fron database
     */
    @Test
    public void findItemByIdTest() {
        final  int searchId = 1;
        Items items =  itemRepository.findById(searchId).get();
        assertEquals("fruit", items.getName());
    }

    /*
     * Read all row database and test them
     */
    @Test
    public void findAllItemTest() {
        List<Items> list = itemRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    /*
     * update the id and test whether changes has occured or not
     */
    @Test
    @Rollback(value = false)
    public void updateItemTest() {
        Items item = new ItemsBuilder(1, "fruit", 23.4f, 5, "imported").getItem();
        Items updatedItems = itemRepository.save(item);
        assertNotNull(updatedItems);
        assertThat(updatedItems.getType()).isEqualTo("imported");
    }

    /*
     * delete the id and test id is present or not
     */
    @Test
    public void deleteItemTest() {
        boolean exitBeforeDelete = itemRepository.findById(1).isPresent();
        itemRepository.deleteById(1);
        assertEquals(true, exitBeforeDelete);
        boolean notExitAfterDelete = itemRepository.findById(1).isPresent();
        assertNotEquals(true, notExitAfterDelete);
    }


}
