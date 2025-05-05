package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Diagnostics", description = "Check")
public class DiagnosticController {

    @GetMapping("/health")
    @Operation(summary = "Check", description = "Returns 200 if okay")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Service works");
    }
}