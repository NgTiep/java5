package com.sd17318.assigment1.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @NotNull(message = "Trường thông tin không được để trống")
    private Integer id;

    @NotBlank(message = "Trường thông tin không được để trống")
    private String name;

    private Category category;

    @NotNull(message = "Trường thông tin không được để trống")
    private Integer price;
}
