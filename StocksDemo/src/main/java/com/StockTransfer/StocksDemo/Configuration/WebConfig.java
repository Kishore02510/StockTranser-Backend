package com.StockTransfer.StocksDemo.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all origins, or specify your frontend URL for more security
        registry.addMapping("/**")  // Apply to all endpoints
                .allowedOrigins("http://127.0.0.1:5500/")  // Adjust this if your frontend is on a different port
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow sending credentials like cookies
    }
}
