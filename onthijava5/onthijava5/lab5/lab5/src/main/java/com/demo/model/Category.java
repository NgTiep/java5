package com.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Categories")
public class Category {
    @Id String id;
    String name;

    @OneToMany(mappedBy = "category")
    List<Product> products;
}
