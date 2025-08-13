package com.example.week_01_hello_spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "World") String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(@RequestParam(defaultValue = "World") String name){
        return "Goodbye, " + name + "!";
    }
}
