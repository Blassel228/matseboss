package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SwaggerValidationRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SwaggerValidationRunner.class);

    @Value("${springdoc.api-docs.path}")
    private String apiDocsPath;

    @Value("${springdoc.swagger-ui.path}")
    private String swaggerUiPath;

    @Override
    public void run(String... args) {
        logger.info("Swagger configuration:");
        logger.info("DOCUMENTATION ADDRESS: {}", apiDocsPath);
        logger.info("Swagger UI accasible by: {}", swaggerUiPath);
        logger.info("Accessibility of documentation check: http://localhost:8080{}", apiDocsPath);
        logger.info("Accessibility of UI: http://localhost:8080{}", swaggerUiPath);
    }
}