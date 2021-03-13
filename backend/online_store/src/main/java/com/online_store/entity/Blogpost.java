package com.online_store.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "blogpost")
@Getter
@Setter
public class Blogpost {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "img_url")
    private String img_url;

    @Column(name = "title")
    private String title;
}
