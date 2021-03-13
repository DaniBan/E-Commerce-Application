package com.online_store.controller;

import com.online_store.dao.ProductCategoryRepository;
import com.online_store.dao.ProductRepository;
import com.online_store.dto.ProductDTO;
import com.online_store.entity.Product;
import com.online_store.entity.ProductCategory;
import com.online_store.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateTutorial(@PathVariable("id") int id, @RequestBody Product product) {
        // get product by id
        Optional<Product> productData = productRepository.findById(id);

        // if present update product with the request body data
        if (productData.isPresent()) {
            Product _product = productData.get();
            _product.setName(product.getName());
            _product.setUnitPrice((int)product.getUnitPrice());
            _product.setStock((int)product.getStock());
            _product.setDescription(product.getDescription());
            return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Product createUser(@RequestBody ProductDTO product){
        // populate product with the request body data
        Product p = new Product();
        p.setName(product.name);
        p.setStock(product.stock);
        p.setUnitPrice(product.unitPrice);
        p.setImage_url(product.image_url);
        p.setDescription(product.description);
        p.setCategory(this.productCategoryRepository.findProductCategoryById(product.category));

        try {
            Product response = this.productRepository.save(p);
            return response;
        } catch (Exception e) {
            System.out.println("An error has occured");
        }

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") int id) {
        try {
            // delete product by id
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
