package com.ibn.inventoryservice.repository;

import com.ibn.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findBySkuCode(String skuCode);

}
