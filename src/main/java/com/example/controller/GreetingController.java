package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingController {

    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("${my.ending}")
    private String endingMessage;

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok(greetingMessage);
    }

    @GetMapping("/good-bye")
    public ResponseEntity<String> goodBye(){
        return ResponseEntity.ok(endingMessage);
    }
}
