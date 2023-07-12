package com.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
}
