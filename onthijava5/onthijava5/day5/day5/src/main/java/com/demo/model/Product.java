package com.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="product")
public class Product {
    @Id @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    Integer id;
    String name;
    int price;
    @ManyToOne @JoinColumn(name="category_id")
    Category category;
}
