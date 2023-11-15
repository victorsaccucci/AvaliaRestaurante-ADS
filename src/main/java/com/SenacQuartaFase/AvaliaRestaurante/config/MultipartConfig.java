package com.SenacQuartaFase.AvaliaRestaurante.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class MultipartConfig {

    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver resolver() {
        return new StandardServletMultipartResolver();
    }
}
