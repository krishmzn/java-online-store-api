package com.ozzy.osbourne.controller;

import com.ozzy.osbourne.entity.Product;
import com.ozzy.osbourne.service.ProductService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addproduct")
    public Product addProduct (@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addproducts")
    public String addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return  service.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/productname/{name}")
    public Product findProductByName(String name) {
        return service.getProductByName(name);
    }

//    @PostMapping("/update")
//    public Product updateProduct(@RequestBody Product product) {
//        return service.updateProduct(product);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        try {
            ResponseEntity<String> updatedProduct = service.updateProduct(product);
            if (updatedProduct != null) {
                return ResponseEntity.ok("Product with ID  updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating product: " + e.getMessage());
        }
    }
}
