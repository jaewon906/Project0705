package com.miniproject0705.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
// /upload/로 시작하는 모든 요청에 대해 데이터를 제공
public class WebConfig implements WebMvcConfigurer { // 웹 애플리케이션의 MVC 구성을 조정할 수 있습니다.

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String resourcePath = "/upload/**";
        String savePath = "file:\\\\C:\\Users\\Administrator\\Desktop\\store\\";
        registry.addResourceHandler(resourcePath).addResourceLocations(savePath);
    }
}
