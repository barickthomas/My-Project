package com.springboot.newproject.service;

import com.springboot.newproject.entity.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory createInventory(Inventory inventory);
    List<Inventory> getAllInventories();
    Inventory getInventoryById(Long id);
    Inventory updateInventory(Long id,Inventory inventory);
    void deleteInventory(Long id);


}
