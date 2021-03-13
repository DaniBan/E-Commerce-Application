package com.online_store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private int unitPrice;

    @Column(name = "image_url")
    private String image_url;

    @Column(name= "description")
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_category", nullable=false)
    private ProductCategory category;

    public Product(){}

    public Product(String name, int stock, int unitPrice, String image_url, String description, ProductCategory category){
        this.name = name;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.image_url = image_url;
        this.description = description;
        this.category = category;
    }

}
