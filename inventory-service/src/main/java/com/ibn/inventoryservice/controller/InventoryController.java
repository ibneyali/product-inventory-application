package com.ibn.inventoryservice.controller;

import com.ibn.inventoryservice.model.Inventory;
import com.ibn.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    InventoryService inventorySevice;

    @RequestMapping(value = "/{sku-code}", method = RequestMethod.GET)
    @Transactional
    public Inventory isInStock(@PathVariable("sku-code") String skuCode){
        return inventorySevice.isInStock(skuCode);
    }
}
