package com.online_store.dao;

import com.online_store.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // find product by category method
    Page<Product> findByCategoryId(@RequestParam("idproduct") int id, Pageable pageable);

    // find product where name contains a keyword
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
