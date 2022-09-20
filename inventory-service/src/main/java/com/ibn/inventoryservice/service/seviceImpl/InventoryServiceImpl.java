package com.ibn.inventoryservice.service.seviceImpl;

import com.ibn.inventoryservice.model.Inventory;
import com.ibn.inventoryservice.repository.InventoryRepository;
import com.ibn.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;
    @Override
    public Inventory isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode);
    }
}
