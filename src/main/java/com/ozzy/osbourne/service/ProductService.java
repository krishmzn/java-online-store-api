package com.ozzy.osbourne.service;

import com.ozzy.osbourne.entity.Product;
import com.ozzy.osbourne.repository.ProductRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public String saveProducts(List<Product> products) {
        try {
            repository.saveAll(products);
            return "Products saved Suscessfully";
        }
        catch (Exception e){
            return "Error saving Products: " + e.getMessage();
        }
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public ResponseEntity<String> deleteProduct(int id) {
        try {
        repository.deleteById(id);
        return ResponseEntity.ok("Product deleted suscessfully: " + id);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Product Not Found");
        }
    }

    public ResponseEntity<String> updateProduct(Product product) {
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuality(product.getQuality());
        existingProduct.setPrice(product.getPrice());
        repository.save(existingProduct);

        return ResponseEntity.ok("Product Updated Suscessfully");
    }
}
