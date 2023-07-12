package com.demo.model;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@Data
public class Product {
    Integer id;
    @NotBlank(message="{err1}") String name;
    Integer price;
    Category category;
    Integer[] categIds;
    MultipartFile image;
}
