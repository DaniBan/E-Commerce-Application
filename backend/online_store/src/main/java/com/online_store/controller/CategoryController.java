package com.online_store.controller;

import com.online_store.dao.ProductCategoryRepository;
import com.online_store.entity.ProductCategory;
import com.online_store.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @PostMapping("/post")
    public ResponseEntity<ProductCategory> createUser(@RequestBody ProductCategory productCategory){
        try {
            // post category to the data base
            ProductCategory _category = productCategoryRepository
                    .save(new ProductCategory(productCategory.getCategoryName()));
            return new ResponseEntity<>(_category, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductCategory> updateTutorial(@PathVariable("id") int id, @RequestBody ProductCategory category) {
        // get product category based on id
        Optional<ProductCategory> data = productCategoryRepository.findById(id);

        // if present, update the category
        if (data.isPresent()) {
            ProductCategory _category = data.get();
            _category.setCategoryName(category.getCategoryName());
            return new ResponseEntity<>(productCategoryRepository.save(_category), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") int id) {
        try {
            // delete category by id
            productCategoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
