package com.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {


    @NotNull(message = "Trường thông tin không được để trống")
    private Integer id;

    @NotBlank(message = "Trường thông tin không được để trống")
    private String name;

    private Category category;

    @NotNull(message = "Trường thông tin không được để trống")
    private Integer price;
}
