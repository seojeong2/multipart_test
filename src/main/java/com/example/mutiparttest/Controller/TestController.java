package com.example.mutiparttest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String testGet() {

        return "TestGet";
    }

    @PostMapping("/test")
    public String testPost( ) {

        return "TestPost";
    }
}
