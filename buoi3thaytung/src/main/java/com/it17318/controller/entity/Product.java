package com.it17318.controller.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Product {

    private int id;
    private String name;
    private int price;
    private Category category;
    private MultipartFile image;
}
