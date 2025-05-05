package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Діагностика", description = "Ендпоїнти для перевірки роботи API")
public class DiagnosticController {

    @GetMapping("/health")
    @Operation(summary = "Перевірити стан сервісу", description = "Повертає статус 200 ОК, якщо сервіс працює нормально")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Сервіс працює нормально");
    }
}