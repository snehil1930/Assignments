package com.example.Assignment4;


import com.example.Assignment4.entity.Items;
import com.example.Assignment4.entity.ItemsBuilder;
import com.example.Assignment4.repository.ItemRepository;
import com.example.Assignment4.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


/*
 * It is use to test CRUD operation in database
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;
    /*
     *injection of item repository
     */
    @InjectMocks
    private ItemService itemService;

    /*
     * It creates the row of data in datacase
     */
    @Test
    public void createItemTest() {
        final var item = new ItemsBuilder(12, "fruit", 23.4f, 5, "raw").getItem();
        lenient().when(itemRepository.save(item)).thenReturn(item);
        final var savedItems = itemService.addItems(item);
        assertNotNull(savedItems);
        assertEquals(savedItems.getName(), "fruit");
        verify(itemRepository).save(any(Items.class));
    }

    /*
     * Read operation from database
     */
    @Test
    public void findItemByIdTest() {
        final int searchId = 1;
        final var item = new ItemsBuilder(1, "fruit", 23.4f, 5, "raw").getItem();
        lenient().when(itemRepository.findById(searchId)).thenReturn(Optional.of(item));
        final Optional<Items> expected = itemService.getItemById(searchId);
        assertNotNull(expected);
    }

    /*
     * Read all row database and test them
     */
    @Test
    public void findAllItemTest() {
        final List<Items> list = new ArrayList<>();
        list.add(new ItemsBuilder(1, "oil", 34.5f, 23, "imported").getItem());
        list.add(new ItemsBuilder(2, "oil", 34.5f, 23, "imported").getItem());

        list.add(new ItemsBuilder(3, "oil", 34.5f, 23, "imported").getItem());
        lenient().when(itemRepository.findAll()).thenReturn(list);
        final var expected = itemService.getItems();
        assertEquals(expected, list);
    }

    /*
     * update the id and test whether changes has occured or not
     */
    @Test
    public void updateItemTest() {
        final var item = new ItemsBuilder(1, "fruit", 23.4f, 5, "imported").getItem();
        lenient().when(itemRepository.save(item)).thenReturn(item);
        final var expected = itemService.updateItem(item, 1);
        assertNotNull(expected);
        verify(itemRepository).save(any(Items.class));
    }

    /*
     * delete the id and test id is present or not
     */
    @Test
    public void deleteItemTest() {
        itemService.deleteItemById(1);
        itemService.deleteItemById(1);
        verify(itemRepository, times(2)).deleteById(1);
    }


}
