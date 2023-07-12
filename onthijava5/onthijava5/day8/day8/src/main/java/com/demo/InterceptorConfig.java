package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class InterceptorConfig
    implements WebMvcConfigurer
{
    @Autowired
    MyInterceptor interceptor;

    @Override
    public void addInterceptors(
        InterceptorRegistry registry)
    {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/admin/**");
    }
}
