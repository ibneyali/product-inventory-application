package com.ibn.inventoryservice.service;

import com.ibn.inventoryservice.model.Inventory;

public interface InventoryService {

    Inventory isInStock(String skuCode);
}
