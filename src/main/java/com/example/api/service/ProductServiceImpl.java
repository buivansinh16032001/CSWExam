package com.example.api.service;

import com.example.api.entity.Product;
import com.example.api.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getListProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        if(product != null){
            return productRepo.save(product);
        }
        return null;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        if(product != null){
            Product p = productRepo.getById(id);
            if(p != null){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setQuantity(product.getQuantity());
                return productRepo.save(p);
            }
        }
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        if(id >= 1){
            Product product = productRepo.getById(id);
            if (product != null){
                productRepo.delete(product);
                return true;
            }
        }
        return false;
    }
}
