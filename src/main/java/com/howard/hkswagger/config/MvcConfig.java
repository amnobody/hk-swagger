package com.howard.hkswagger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/21
 * @description
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Resource
    ResponseResultInterceptor responseResultInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseResultInterceptor).addPathPatterns("/user/**");
    }
}
