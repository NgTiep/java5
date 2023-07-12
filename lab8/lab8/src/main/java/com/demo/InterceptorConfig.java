package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class InterceptorConfig
        implements WebMvcConfigurer {
    @Autowired
    AuthInterceptor auth;

    @Override
    public void addInterceptors(
            InterceptorRegistry registry) {
        registry.addInterceptor(auth)
                .addPathPatterns("/account/edit",
                        "/account/chgpwd", "/order/**", "/admin/**")
                .excludePathPatterns("/assets/**", "/admin/home/index");

    }
}
