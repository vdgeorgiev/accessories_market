package com.example.PhoneAccessories.Controller;

import com.example.PhoneAccessories.Dto.ItemDto;
import com.example.PhoneAccessories.Model.Item;
import com.example.PhoneAccessories.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping(value = "cases")
@RestController
public class ItemController {
    ItemService itemService;

    @Autowired
    ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Set<ItemDto> findAll() {
        return itemService.returnAllCases();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody Item item) {
        itemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteByUsername(@PathVariable Long id) {
        itemService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
