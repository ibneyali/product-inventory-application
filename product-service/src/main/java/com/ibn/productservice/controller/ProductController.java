package com.ibn.productservice.controller;

import com.ibn.productservice.dto.ProductRequest;
import com.ibn.productservice.dto.ProductResponse;
import com.ibn.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.saveProduct(productRequest);
    }


    @RequestMapping(value = "/product", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
