package com.jgelpud.project.APIusersAccess.Configuration;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigurationCors implements WebMvcConfigurer {

    public static final int PORT = 3000;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:"+PORT)
                .allowedMethods("*");
    }
}
