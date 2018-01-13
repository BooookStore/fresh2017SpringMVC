package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.Product;

public interface ProductRepository {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductByFilter(Map<String, List<String>> filterParams);

    Product getProductById(String productId);

    void updateStock(String productId, long noOfUnits);

    void addNewProduct(Product newProduct);
}