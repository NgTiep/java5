package com.demo;

import com.demo.model.SanPham;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("p2")
    SanPham getSanPham(){
        return new SanPham(1,"Inphon15", 12000);
    }

}
