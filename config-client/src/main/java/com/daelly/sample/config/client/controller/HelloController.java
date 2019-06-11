package com.daelly.sample.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${xslde.name}")
    private String name;

    @GetMapping("/name")
    public String name() {
        return "the name from config server is:" + name;
    }
}
