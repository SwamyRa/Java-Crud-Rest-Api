package com.joesalt.tutorial.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        log.info("Inside Health Check Controller");
        return new ResponseEntity<>("Application is running successfully",HttpStatus.OK);
    }
}
