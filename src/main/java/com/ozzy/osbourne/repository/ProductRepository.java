package com.ozzy.osbourne.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ozzy.osbourne.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
