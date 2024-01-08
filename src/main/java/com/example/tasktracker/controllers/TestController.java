package com.example.tasktracker.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping()
    public ResponseEntity getTest(){
        try {
            return ResponseEntity.ok("Server works");

        }
         catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
         }
    }
}
