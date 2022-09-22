package com.ibn.inventoryservice.controller;

import com.ibn.inventoryservice.dto.InventoryResponse;
import com.ibn.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    InventoryService inventorySevice;

    @RequestMapping(method = RequestMethod.GET)
    @Transactional
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventorySevice.isInStock(skuCode);
    }
}
