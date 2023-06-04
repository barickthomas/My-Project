package com.springboot.newproject.serviceImpl;

import com.springboot.newproject.entity.Inventory;
import com.springboot.newproject.repository.InventoryRepository;
import com.springboot.newproject.service.InventoryService;
import jakarta.persistence.Id;

import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private InventoryRepository inventoryRepository;
    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryById(Long id) {
        Inventory inventory = inventoryRepository.findById(id).get();
        return inventory;
    }

    @Override
    public Inventory updateInventory(Long id, Inventory inventory) {
        Inventory existingInventory = inventoryRepository.findById(inventory.getId()).get();
        existingInventory.setName(inventory.getName());
        existingInventory.setType(inventory.getType());
        existingInventory.setComponent(inventory.getComponent());

        Inventory updatedInventory = inventoryRepository.save(existingInventory);
        return updatedInventory;
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);

    }
}
