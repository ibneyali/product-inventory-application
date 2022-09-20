package com.ibn.productservice.service;

import com.ibn.productservice.dto.ProductRequest;
import com.ibn.productservice.dto.ProductResponse;
import com.ibn.productservice.model.Product;

import java.util.List;

public interface ProductService {

    public void saveProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
