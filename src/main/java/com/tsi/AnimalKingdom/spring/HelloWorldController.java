package com.tsi.AnimalKingdom.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello from Mat.";
    }
}
