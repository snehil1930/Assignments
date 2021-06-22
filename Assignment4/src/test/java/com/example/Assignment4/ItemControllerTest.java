package com.example.Assignment4;


import com.example.Assignment4.controller.ItemController;
import com.example.Assignment4.entity.Items;
import com.example.Assignment4.entity.ItemsBuilder;
import com.example.Assignment4.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*
 * controller testing is done in this class
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@WebMvcTest(controllers = ItemController.class)
@ActiveProfiles("test")
public class ItemControllerTest {

    /*injecting mockito
     * */
    @Autowired
    private MockMvc mockMvc;

    /*
     * Mocking of item service
     * */
    @MockBean
    private ItemService itemService;

    /*
     * Object mapping from string to json
     * */
    @Autowired
    private ObjectMapper objectMapper;

    /*
     * item list for setup
     * */
    private List<Items> itemsList;

    /*
     * before setup of each test
     * */

    @BeforeEach
    void init() {
        this.itemsList = new ArrayList<>();
        this.itemsList.add(new ItemsBuilder(2, "wheat", 12.0f, 2, "raw").getItem());
        this.itemsList.add(new ItemsBuilder(3, "bag", 120.0f, 1, "imported").getItem());
    }

    /*
     * get function test from db
     */
    @Test
    void getAllItemTest() throws Exception {
        given(itemService.getItems()).willReturn(itemsList);
        this.mockMvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(itemsList.size())));
    }


    /*
     * get function of id test
     */
    @Test
    void getItemByIdTest() throws Exception {
        final var item = new ItemsBuilder(2, "wheat", 12.0f, 2, "raw").getItem();
        given(itemService.getItemById(2)).willReturn(Optional.of(item));
        this.mockMvc.perform((get("/item/{id}", 2)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(item.getName())));
    }


    /*
     * IF ID not exist
     * */
    @Test
    void getItemByIdNotExistTest() throws Exception {

        given(itemService.getItemById(2)).willReturn(Optional.empty());
        this.mockMvc.perform(get("/item/{id}", 2))
                .andExpect(status().isNotFound());
    }

    /*
     * post testing
     * */
    @Test
    void postItemTest() throws Exception {
        final var item = new ItemsBuilder(4, "wheat", 12.0f, 2, "raw").getItem();
        given(itemService.addItems(any(Items.class))).willAnswer((invocation -> invocation.getArgument(0)));
        this.mockMvc.perform(put("/item")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is(item.getName())))
                .andExpect(jsonPath("type", is(item.getType())));
    }

    /*
     * update the id test
     */
    @Test
    void updateItemByIdTest() throws Exception {
        final var item = new ItemsBuilder(2, "wool", 43.3f, 3, "manufactured").getItem();
        given(itemService.getItemById(2)).willReturn(Optional.of(item));
        given(itemService.updateItem(any(Items.class), 1)).willAnswer(invocation -> invocation.getArgument(0));
        this.mockMvc.perform(put("/item/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is(item.getName())));
    }

    /*
     * delete the item by id test
     * */
    @Test
    void deleteItemByIdTest() throws Exception {
        final var item = new ItemsBuilder(1, "wool", 43.3f, 3, "manufactured").getItem();
        given(itemService.getItemById(1)).willReturn(Optional.of(item));
        doNothing().when(itemService).deleteItemById(1);
        this.mockMvc.perform(delete("/item/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(item.getName())));

    }


    /*
     * delete id is not present test
     * */
    @Test
    void deleteItemByIdNoTExistTest() throws Exception {
        given(itemService.getItemById(1)).willReturn(Optional.empty());
        this.mockMvc.perform(delete("/item/{id}", 1))
                .andExpect(status().isNotFound());
    }
}
