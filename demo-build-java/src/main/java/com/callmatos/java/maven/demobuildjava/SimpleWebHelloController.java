package com.callmatos.java.maven.demobuildjava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleWebHelloController {

    @GetMapping("/")
    public String index(){
        return "Gettings from Spring Boot!";
    }
}
