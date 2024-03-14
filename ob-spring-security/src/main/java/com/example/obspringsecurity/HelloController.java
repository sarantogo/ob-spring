package com.example.obspringsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/Hello")
    public String HelloWorld() {
        return "Hello Everybody!!!!!";
    }

    @GetMapping("/test")
    public String HelloWorldTest() {
        return "Hello Everybody!!!!!";
    }

}
