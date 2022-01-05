package com.example.api.service;


import com.example.api.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getListProduct();

    Product addProduct(Product product);

    Product updateProduct(int id, Product product);

    boolean deleteProduct(int id);
}
