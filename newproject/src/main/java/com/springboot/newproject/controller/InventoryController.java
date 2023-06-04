package com.springboot.newproject.controller;

import com.springboot.newproject.entity.Inventory;
import com.springboot.newproject.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private InventoryService inventoryService;

    @PostMapping
    ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){
        return new ResponseEntity<>(inventoryService.createInventory(inventory), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Inventory> getAllInventories(){
        return inventoryService.getAllInventories();
    }

    @GetMapping("{id}")
    public ResponseEntity<Inventory> getInventoryId(@PathVariable Long id){
        return new ResponseEntity<>(inventoryService.getInventoryById(id),HttpStatus.OK);

    }
    @PutMapping("{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long id,@RequestBody Inventory inventory){
        return new ResponseEntity<>(inventoryService.updateInventory(id,inventory), HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long id){
        inventoryService.deleteInventory(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);

    }



}
