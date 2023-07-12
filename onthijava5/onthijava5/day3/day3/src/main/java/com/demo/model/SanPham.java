package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@AllArgsConstructor
@Component("p1")
//@SessionScope

public class SanPham {
    private Integer id;
    private String name;
    private Integer price;

    public SanPham(){
        id=1;
        name="iphon14";
        price=1222;
    }
}
